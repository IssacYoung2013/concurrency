package com.issac.concurrency.example.mq.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 * author:  ywy
 * date:    2018-12-31
 * desc:
 */
@Component
public class RabbitMQClient {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(QueueConstants.TEST,message);
    }

}
