package com.issac.concurrency.disruptor.high.chain;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 *
 * author:  ywy
 * date:    2019-01-01
 * desc:
 */
public class Handler1 implements EventHandler<Trade>,WorkHandler<Trade>{

    // EventHandler
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
      this.onEvent(event);
    }

    // WorkHandler
    @Override
    public void onEvent(Trade event) throws Exception {
        System.err.println("handler 1 : SET NAME");
        event.setName("H1");
        Thread.sleep(1000);
    }
}
