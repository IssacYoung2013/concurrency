package com.issac.concurrency.disruptor.high.chain;

import com.lmax.disruptor.EventHandler;

/**
 * author:  ywy
 * date:    2019-01-01
 * desc:
 */
public class Handler4 implements EventHandler<Trade> {

    // EventHandler
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("handler 4 : SET PRICE");
        event.setPrice(17.0);
    }
}
