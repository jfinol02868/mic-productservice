package com.solutionsone.mic.productservice.infrastructure.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;

public interface KafkaProducerMessage<T, K, V> {

    default void KafkaProducer(KafkaTemplate<K, V> kafkaTemplate) {};

    void sendMessage(T topic, V entity);

    void sendMessageToMultipleTopics(T[] topics, V entity);
}
