package com.issac.concurrency.disruptor.quickstart;

import com.lmax.disruptor.EventHandler;

/**
 *
 * author:  ywy
 * date:    2018-12-31
 * desc:
 */
public class OrderEventHandler implements EventHandler<OrderEvent> {
    @Override
    public void onEvent(OrderEvent orderEvent, long l, boolean b) throws Exception {
        Thread.sleep(Integer.MAX_VALUE);
        System.err.println("消费者：" + orderEvent.getValue());
    }
}
