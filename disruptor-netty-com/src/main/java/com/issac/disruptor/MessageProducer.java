package com.issac.disruptor;

import com.issac.entity.TranslatorData;
import com.issac.entity.TranslatorDataWapper;
import com.lmax.disruptor.RingBuffer;
import io.netty.channel.ChannelHandlerContext;

/**
 * author:  ywy
 * date:    2019-01-04
 * desc:
 */
public class MessageProducer {

    private String producerId;

    private RingBuffer<TranslatorDataWapper> ringBuffer;

    public MessageProducer(String producerId, RingBuffer<TranslatorDataWapper> ringBuffer) {
        this.producerId = producerId;
        this.ringBuffer = ringBuffer;
    }

    public void onData(TranslatorData data, ChannelHandlerContext ctx) {
        long sequence = ringBuffer.next();
        try {
            TranslatorDataWapper wapper = ringBuffer.get(sequence);
            wapper.setData(data);
            wapper.setChannelHandlerContext(ctx);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
