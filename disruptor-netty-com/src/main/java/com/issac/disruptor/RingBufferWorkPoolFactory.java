package com.issac.disruptor;

import com.issac.entity.TranslatorData;
import com.issac.entity.TranslatorDataWapper;
import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * author:  ywy
 * date:    2019-01-04
 * desc:
 */
public class RingBufferWorkPoolFactory {

    private static class SingletonHolder {
        static final RingBufferWorkPoolFactory instance = new RingBufferWorkPoolFactory();
    }

    private RingBufferWorkPoolFactory() {
    }

    public static RingBufferWorkPoolFactory getInstance() {
        return SingletonHolder.instance;
    }

    private Map<String, MessageProducer> producers = new ConcurrentHashMap<>();

    private Map<String, MessageConsumer> consumers = new ConcurrentHashMap<>();

    private RingBuffer<TranslatorDataWapper> ringBuffer;

    private WorkerPool<TranslatorDataWapper> workerPool;

    private SequenceBarrier sequenceBarrier;

    public void initAndStart(ProducerType type, int bufferSize, WaitStrategy waitStrategy, MessageConsumer[] consumers) {
        // 1. 构建ringBuffer对象
        this.ringBuffer = RingBuffer.create(type, new EventFactory<TranslatorDataWapper>() {
            @Override
            public TranslatorDataWapper newInstance() {
                return new TranslatorDataWapper();
            }
        }, bufferSize, waitStrategy);

        // 2. 设置序号栅栏
        this.sequenceBarrier = this.ringBuffer.newBarrier();

        // 3. 设置工作池
        this.workerPool = new WorkerPool<TranslatorDataWapper>(this.ringBuffer, this.sequenceBarrier
                , new EventExceptionHanlder(), consumers);

        // 4. 把所构建的消费者置入池中
        for (MessageConsumer message :
                consumers) {
            this.consumers.put(message.getConsumerId(), message);
        }

        // 5. 添加我们的sequences
        this.ringBuffer.addGatingSequences(this.workerPool.getWorkerSequences());

        // 6. 启动线程池
        this.workerPool.start(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2));
    }

    public MessageProducer getMessageProducer(String producerId) {
        MessageProducer messageProducer = this.producers.get(producerId);
        if (null == messageProducer) {
            messageProducer = new MessageProducer(producerId, this.ringBuffer);
            this.producers.put(producerId, messageProducer);
        }

        return messageProducer;
    }


    static class EventExceptionHanlder implements ExceptionHandler<TranslatorDataWapper> {
        @Override
        public void handleEventException(Throwable ex, long sequence, TranslatorDataWapper event) {

        }

        @Override
        public void handleOnStartException(Throwable ex) {

        }

        @Override
        public void handleOnShutdownException(Throwable ex) {

        }
    }
}
