package com.solutionsone.mic.productservice.infrastructure.kafka.consumer;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;

public interface KafkaConsumerMessage<K, V> {

    public KStream<K, V> processKafkaStreams(StreamsBuilder streamsBuilder);
}
