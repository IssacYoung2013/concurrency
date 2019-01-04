package com.issac.concurrency.example.mq;

import lombok.Data;

import java.util.Date;

/**
 *
 * author:  ywy
 * date:    2018-12-30
 * desc:
 */
@Data
public class Message {

    private Long id;

    private String msg;

    private Date sendTime;
}
