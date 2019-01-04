package com.issac.concurrency.disruptor.high.chain;

import com.lmax.disruptor.EventHandler;

import java.util.UUID;

/**
 *
 * author:  ywy
 * date:    2019-01-01
 * desc:
 */
public class Handler2 implements EventHandler<Trade>{

    // EventHandler
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("handler 2 : SET ID");
        event.setId(UUID.randomUUID().toString());
        Thread.sleep(2000);
    }
}
