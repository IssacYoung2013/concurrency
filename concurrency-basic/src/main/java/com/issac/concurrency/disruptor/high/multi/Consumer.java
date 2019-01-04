package com.issac.concurrency.disruptor.high.multi;

import com.lmax.disruptor.WorkHandler;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * author:  ywy
 * date:    2019-01-01
 * desc:
 */
public class Consumer implements WorkHandler<Order> {

    private String consumerId;

    private static AtomicInteger count = new AtomicInteger(0);

    private Random random = new Random();

    public Consumer(String consumerId) {
        this.consumerId = consumerId;
    }

    @Override
    public void onEvent(Order event) throws Exception {
        Thread.sleep(1 * random.nextInt(5));
        System.err.println("当前消费者：" + this.consumerId +"，消费信息：" + event.getId());
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
