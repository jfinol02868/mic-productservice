package com.solutionsone.mic.productservice.api.controller;

import com.solutionsone.mic.productservice.infrastructure.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @Value("${spring.kafka.streams.topics}")
    private String[] topics;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/send/{topic}")
    public String sendMessageToSpecificTopic(@PathVariable String topic, @RequestParam String message) {
        kafkaProducer.sendMessage(topic, message);
        return "Mensaje enviado al tópico: " + topic;
    }

    @PostMapping("/send")
    public String sendMessageToMultipleTopics(@RequestParam String message) {
        kafkaProducer.sendMessageToMultipleTopics(topics, message);
        return "Mensaje enviado a múltiples tópicos";
    }
}
