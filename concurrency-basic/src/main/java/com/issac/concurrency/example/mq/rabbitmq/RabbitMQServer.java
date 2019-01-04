package com.issac.concurrency.example.mq.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * author:  ywy
 * date:    2018-12-31
 * desc:
 *
 */
@Slf4j
@Component
public class RabbitMQServer {
    @RabbitListener(queues = QueueConstants.TEST)
    private void receive(String message) {
        log.info("{}",message);
    }
}
