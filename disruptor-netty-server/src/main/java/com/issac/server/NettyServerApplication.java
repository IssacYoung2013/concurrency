package com.issac.server;

import com.issac.disruptor.MessageConsumer;
import com.issac.disruptor.RingBufferWorkPoolFactory;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(NettyServerApplication.class, args);

        MessageConsumer[] consumers = new MessageConsumer[4];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new MessageConsumerImpl4Server("code:sessionId:" + i);
        }

        RingBufferWorkPoolFactory.getInstance().initAndStart(ProducerType.MULTI, 1024 * 1024, new BlockingWaitStrategy(), consumers);
        new NettyServer();

    }

}

