package com.issac.client;

import com.issac.disruptor.MessageConsumer;
import com.issac.entity.TranslatorData;
import com.issac.entity.TranslatorDataWapper;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * author:  ywy
 * date:    2019-01-04
 * desc:
 */
@Slf4j
public class MessageConsumerImpl4Client extends MessageConsumer {

    public MessageConsumerImpl4Client(String consumerId) {
        super(consumerId);
    }

    @Override
    public void onEvent(TranslatorDataWapper event) throws Exception {
        TranslatorData response = (TranslatorData) event.getData();

        try {
            log.info("Client端：id= " + response.getId() + " name=" + response.getName() + " message=" + response.getMessage());

        } finally {
            // 一定要注意用完了缓存要进行释放
            ReferenceCountUtil.release(response);
        }
    }
}
