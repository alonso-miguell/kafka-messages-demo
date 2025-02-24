package com.example.demoKafka.controller;

import com.example.demoKafka.producer.MessageProducer;
import com.example.demoKafka.producer.OtherKafkaProducer;
import com.example.demoKafka.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaRestController {

    @Value("${myapp.kafka.topic.topic2}")
    String secondTopic;

    @Autowired
    private MessageProducer producer;

    @Autowired
    private OtherKafkaProducer otherProducer;

    @Autowired
    private MessageRepository messageRepo;

    //Send message to kafka
    @GetMapping("/send")
    public String sendMsg(@RequestParam("msg") String message) {
        producer.sendMessage(message);
        return "" + "'+message +'" + " sent successfully!";
    }

    //Send message to kafka
    @GetMapping("/sendByOther")
    public String sendOtherMsg(@RequestParam("msg") String message) {
        otherProducer.sendMessage(secondTopic, message);
        return "message sent successfully to "+ secondTopic +"!!";
    }

    //Read all messages
    @GetMapping("/getAll")
    public String getAllMessages() {
        return messageRepo.getAllMessages();
    }
}
