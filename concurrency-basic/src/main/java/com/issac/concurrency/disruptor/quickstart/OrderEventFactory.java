package com.issac.concurrency.disruptor.quickstart;

import com.lmax.disruptor.EventFactory;

/**
 *
 * author:  ywy
 * date:    2018-12-31
 * desc:  创建订单对象
 */
public class OrderEventFactory implements EventFactory<OrderEvent>{

    @Override
    public OrderEvent newInstance() {
        return new OrderEvent(); // 这个方法为了返回空的数据对象（Event）
    }
}
