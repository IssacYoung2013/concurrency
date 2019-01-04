package com.issac.concurrency.example.mq.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *
 * author:  ywy
 * date:    2018-12-30
 * desc:
 */
@Component
@Slf4j
public class KafKaReceiver {

    @KafkaListener(topics = {TopicConstant.TEST})
    public void receiver(ConsumerRecord<?,?> record){
        log.info("record:{}",record);
    }
}
