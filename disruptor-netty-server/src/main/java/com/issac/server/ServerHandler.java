package com.issac.server;

import com.issac.entity.TranslatorData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * author:  ywy
 * date:    2019-01-04
 * desc:
 */
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TranslatorData request = (TranslatorData) msg;
        log.info("Server端：id= " + request.getId() + " name=" + request.getName() + " message=" + request.getMessage());

        // 数据库持久化操作IO读写 --》交给一个线程池 去异步的调用执行
        TranslatorData response = new TranslatorData();
        response.setId("resp:" + request.getId());
        response.setName("resp:" + request.getName());
        response.setMessage("resp:" + request.getMessage());

        ctx.writeAndFlush(response); // 写出去然后冲刷到 nio 异步通道，提前释放
    }
}
