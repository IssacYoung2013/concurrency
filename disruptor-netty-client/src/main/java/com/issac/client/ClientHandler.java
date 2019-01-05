package com.issac.client;

import com.issac.disruptor.MessageProducer;
import com.issac.disruptor.RingBufferWorkPoolFactory;
import com.issac.entity.TranslatorData;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.slf4j.Slf4j;

/**
 * author:  ywy
 * date:    2019-01-04
 * desc:
 */
@Slf4j
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

//        try {
//            TranslatorData response = (TranslatorData) msg;
//            log.info("Client端：id= " + response.getId() + " name=" + response.getName() + " message=" + response.getMessage());
//
//        } finally {
//            // 一定要注意用完了缓存要进行释放
//            ReferenceCountUtil.release(msg);
//        }

        TranslatorData response = (TranslatorData) msg;
        String produceId = "code:sessionId:002";
        MessageProducer messageProducer = RingBufferWorkPoolFactory.getInstance().getMessageProducer(produceId);
        messageProducer.onData(response,ctx);
    }
}
