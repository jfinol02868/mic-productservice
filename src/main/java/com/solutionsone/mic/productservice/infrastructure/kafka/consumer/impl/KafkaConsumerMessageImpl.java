package com.solutionsone.mic.productservice.infrastructure.kafka.consumer.impl;

import com.solutionsone.mic.productservice.domain.entity.Brand;
import com.solutionsone.mic.productservice.infrastructure.kafka.consumer.KafkaConsumerMessage;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class KafkaConsumerMessageImpl implements KafkaConsumerMessage<String, Brand> {

    @Bean
    @Override
    public KStream<String, Brand> processKafkaStreams(StreamsBuilder streamsBuilder) {
        String[] topics = {"topic1", "topic2", "topic3"};

        // Crear un KStream que lea desde varios tópicos
        KStream<String, Brand> stream = streamsBuilder.stream(Arrays.asList(topics));

        // Definir la lógica de procesamiento para los mensajes
        stream.foreach((key, value) -> {
            System.out.println("Procesando mensaje: Key=" + key + ", Value=" + value.toString());
        });

        // Puedes agregar más lógica de procesamiento aquí (filtros, mapeos, etc.)
        return stream;
    }
}
