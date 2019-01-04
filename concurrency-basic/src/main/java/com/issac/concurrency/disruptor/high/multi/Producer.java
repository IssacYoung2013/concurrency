package com.issac.concurrency.disruptor.high.multi;

import com.lmax.disruptor.RingBuffer;

/**
 *
 * author:  ywy
 * date:    2019-01-01
 * desc:
 */
public class Producer {

    private RingBuffer<Order> ringBuffer;

    public Producer(RingBuffer<Order> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void sendData(String data) {
        long sequence = ringBuffer.next();
        try {
            Order order = ringBuffer.get(sequence);
            order.setId(data);
        }
        finally {
            ringBuffer.publish(sequence);
        }
    }
}
