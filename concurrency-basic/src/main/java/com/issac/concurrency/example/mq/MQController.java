package com.issac.concurrency.example.mq;

import com.issac.concurrency.example.mq.kafka.KafkaSender;
import com.issac.concurrency.example.mq.rabbitmq.RabbitMQClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * author:  ywy
 * date:    2018-12-31
 * desc:
 */
@RestController
@RequestMapping("/mq")
public class MQController {

    @Resource
    private RabbitMQClient rabbitMQClient;

    @Resource
    private KafkaSender kafkaSender;

    @RequestMapping("/send")
    @ResponseBody
    public String send(@RequestParam("message") String message) {
        rabbitMQClient.send(message);
        kafkaSender.send(message);
        return "success";
    }
}
