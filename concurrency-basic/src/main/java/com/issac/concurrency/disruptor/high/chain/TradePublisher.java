package com.issac.concurrency.disruptor.high.chain;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * author:  ywy
 * date:    2019-01-01
 * desc:
 */
public class TradePublisher implements Runnable {
    
    private Disruptor<Trade> disruptor;
    private CountDownLatch latch;

    private static int PUBLISH_COUNT = 1;

    public TradePublisher(Disruptor<Trade> disruptor, CountDownLatch latch) {
        this.disruptor = disruptor;
        this.latch = latch;
    }

    @Override
    public void run() {
        TradeEventTranslator eventTranslator = new TradeEventTranslator();

        for (int i = 0; i < PUBLISH_COUNT; i++) {
            // 新的提交任务的方式
            disruptor.publishEvent(eventTranslator);
        }
        latch.countDown(); // countDown完了之后 阻塞await才会唤醒
    }
}

class TradeEventTranslator implements EventTranslator<Trade> {

    private Random random = new Random();

    /**
     * 比ringbuffer 更快速 简单
     * @param event
     * @param sequence
     */
    @Override
    public void translateTo(Trade event, long sequence) {
        this.generateTrade(event);
    }

    private void generateTrade(Trade event) {
        event.setPrice(random.nextDouble() * 9999);
    }
}
