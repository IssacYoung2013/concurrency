package com.issac.server;

import com.issac.disruptor.MessageConsumer;
import com.issac.entity.TranslatorData;
import com.issac.entity.TranslatorDataWapper;
import lombok.extern.slf4j.Slf4j;

/**
 * author:  ywy
 * date:    2019-01-04
 * desc:
 */
@Slf4j
public class MessageConsumerImpl4Server extends MessageConsumer {

    public MessageConsumerImpl4Server(String consumerId) {
        super(consumerId);
    }

    @Override
    public void onEvent(TranslatorDataWapper event) throws Exception {

        // 业务逻辑
        TranslatorData request = event.getData();
        log.info("Server端：id= " + request.getId() + " name=" + request.getName() + " message=" + request.getMessage());

        // 数据库持久化操作IO读写 --》交给一个线程池 去异步的调用执行
        TranslatorData response = new TranslatorData();
        response.setId("resp:" + request.getId());
        response.setName("resp:" + request.getName());
        response.setMessage("resp:" + request.getMessage());

        event.getChannelHandlerContext().writeAndFlush(response); // 写出去然后冲刷到 nio 异步通道，提前释放
    }
}
