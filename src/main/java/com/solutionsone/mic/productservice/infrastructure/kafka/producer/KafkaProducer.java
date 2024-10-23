package com.solutionsone.mic.productservice.infrastructure.kafka.producer;

import com.solutionsone.mic.productservice.domain.entity.Brand;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaProducer implements KafkaProducerMessage<String, String, Brand>{

    private final KafkaTemplate<String, Brand> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Brand> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Brand entity) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString() ,entity);
    }

    public void sendMessageToMultipleTopics(String[] topics, Brand entity) {
        for (String topic : topics) {
            kafkaTemplate.send(topic, entity);
        }
    }
}
