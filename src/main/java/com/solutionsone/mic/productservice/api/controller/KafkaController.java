package com.solutionsone.mic.productservice.api.controller;

import com.solutionsone.mic.productservice.domain.entity.Brand;
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
    public String sendMessageToSpecificTopic(@PathVariable String topic, @RequestBody Brand entity) {
        kafkaProducer.sendMessage(topic, entity);
        return "Mensaje enviado al tópico: " + topic;
    }

    @PostMapping("/send")
    public String sendMessageToMultipleTopics(@RequestBody Brand entity) {
        kafkaProducer.sendMessageToMultipleTopics(topics, entity);
        return "Mensaje enviado a múltiples tópicos";
    }
}
