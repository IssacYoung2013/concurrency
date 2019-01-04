package com.issac.concurrency.disruptor.quickstart;

import lombok.Data;

/**
 * author:  ywy
 * date:    2018-12-31
 * desc:
 */
@Data
public class OrderEvent {
    private long value; // 订单的价格
}
