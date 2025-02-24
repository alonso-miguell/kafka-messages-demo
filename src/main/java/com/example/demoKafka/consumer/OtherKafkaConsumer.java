package com.example.demoKafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OtherKafkaConsumer {

    private Logger log = LoggerFactory.getLogger(OtherKafkaConsumer.class);

    //groupId not needed already provided in config class
    @KafkaListener(topics = "${myapp.kafka.topic.topic2}")
    public void consume(String message) {
        log.info("MESSAGE RECEIVED by another kafka consumer -> " + message);
    }
}
