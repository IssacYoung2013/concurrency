package com.issac.concurrency.disruptor.quickstart;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author:  ywy
 * date:    2018-12-31
 * desc:
 */
public class Main {


    public static void main(String[] args) {


        // 0. 参数准备工作
        OrderEventFactory orderEventFactory = new OrderEventFactory();
        int ringBufferSize = 4;
        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        /**
         * 1. EventFactory 消息(event)工厂对象
         * 2. ringBufferSize 容器长度
         * 3. executorService: 线程池（建议使用自定义线程池） RejectExecuationHandler 拒绝策略
         * 4. ProducerType 单生产者还是多生产者
         * 5. WaitStrategy 等待策略
         */
        // 1.   实例化disruptor 对象
        Disruptor<OrderEvent> disruptor = new Disruptor<OrderEvent>(orderEventFactory,
                ringBufferSize,
                executorService,
                ProducerType.SINGLE,
                new BlockingWaitStrategy()
                );

        // 2. 添加消费者监听(disruptor 与 消费者一个关联关系)
        disruptor.handleEventsWith(new OrderEventHandler());

        // 3. 启动disruptor
        disruptor.start();

        // 4. 获取实际存取数据的容器：RingBuffer 环形
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();

        OrderEventProducer producer = new OrderEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);

        for (long i = 0; i < 5; i++) {
            bb.putLong(0,i);
            producer.sendData(bb);
        }

        disruptor.shutdown();
        executorService.shutdown();
    }
}
