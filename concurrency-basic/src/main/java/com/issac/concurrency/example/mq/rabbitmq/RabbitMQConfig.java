package com.issac.concurrency.example.mq.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * author:  ywy
 * date:    2018-12-30
 * desc:
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue() {
        return new Queue(QueueConstants.TEST);
    }
}
