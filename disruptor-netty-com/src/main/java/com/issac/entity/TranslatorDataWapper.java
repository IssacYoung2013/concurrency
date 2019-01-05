package com.issac.entity;

import io.netty.channel.ChannelHandlerContext;
import lombok.Data;

/**
 *
 * author:  ywy
 * date:    2019-01-04
 * desc:
 */
@Data
public class TranslatorDataWapper {

    private TranslatorData data;

    private ChannelHandlerContext channelHandlerContext;

}
