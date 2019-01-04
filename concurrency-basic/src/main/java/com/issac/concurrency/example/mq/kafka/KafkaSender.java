package com.issac.concurrency.example.mq.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.issac.concurrency.example.mq.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * author:  ywy
 * date:    2018-12-30
 * desc:
 */
@Component
@Slf4j
public class KafkaSender {

    @Resource
    private KafkaTemplate kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send(String msg) {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(msg);
        message.setSendTime(new Date());
        log.info("send message:{}",message);
        kafkaTemplate.send(TopicConstant.TEST,gson.toJson(message));
    }

}
