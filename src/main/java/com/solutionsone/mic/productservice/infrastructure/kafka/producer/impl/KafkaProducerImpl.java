package com.solutionsone.mic.productservice.infrastructure.kafka.producer.impl;

import com.solutionsone.mic.productservice.domain.entity.Brand;
import com.solutionsone.mic.productservice.infrastructure.kafka.producer.KafkaProducerMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaProducerImpl implements KafkaProducerMessage<String, String, Brand> {

    private final KafkaTemplate<String, Brand> kafkaTemplate;

    public KafkaProducerImpl(KafkaTemplate<String, Brand> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String topic, Brand entity) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString() ,entity);
    }

    @Override
    public void sendMessageToMultipleTopics(String[] topics, Brand entity) {
        for (String topic : topics) {
            kafkaTemplate.send(topic, entity);
        }
    }
}
