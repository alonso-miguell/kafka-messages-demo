package com.example.demoKafka.consumer;

import com.example.demoKafka.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    private MessageRepository messageRepo;

    //Simple Kafka listener
    @KafkaListener(topics = "${myapp.kafka.topic.topic1}", groupId = "xyz")
    public void consume(String message) {
        log.info("MESSAGE RECEIVED AT CONSUMER END -> " + message);
        messageRepo.addMessage(message);
    }
}
