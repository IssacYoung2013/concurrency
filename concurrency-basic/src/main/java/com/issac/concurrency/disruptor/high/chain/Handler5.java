package com.issac.concurrency.disruptor.high.chain;

import com.lmax.disruptor.EventHandler;

/**
 * author:  ywy
 * date:    2019-01-01
 * desc:
 */
public class Handler5 implements EventHandler<Trade> {

    // EventHandler
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("handler 5 : GET PRICE：" + event.getPrice());
        event.setPrice(event.getPrice() + 3.0);
    }
}
