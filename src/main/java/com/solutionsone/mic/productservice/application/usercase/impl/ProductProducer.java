package com.solutionsone.mic.productservice.application.usercase.impl;

import com.solutionsone.mic.productservice.domain.entity.Product2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {

    private static final String TOPIC_NAME = "products-input";


    private final KafkaTemplate<String, Product2> kafkaTemplate;

    public ProductProducer(KafkaTemplate<String, Product2> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendProduct(Product2 product) {
        kafkaTemplate.send(TOPIC_NAME, product);
    }
}
