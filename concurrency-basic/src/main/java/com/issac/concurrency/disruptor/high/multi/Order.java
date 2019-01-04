package com.issac.concurrency.disruptor.high.multi;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 相当于 Event
 * author:  ywy
 * date:    2019-01-01
 * desc:
 */
@Data
public class Order {

    private String id;

    private String name;

    private double price;
}
