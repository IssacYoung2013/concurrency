package com.issac.disruptor;

import com.issac.entity.TranslatorDataWapper;
import com.lmax.disruptor.WorkHandler;
import lombok.Data;

/**
 *
 * author:  ywy
 * date:    2019-01-04
 * desc:
 */
@Data
public abstract class MessageConsumer implements WorkHandler<TranslatorDataWapper> {

    protected String consumerId;

    public MessageConsumer(String consumerId) {
        this.consumerId = consumerId;
    }
}
