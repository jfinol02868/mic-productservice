package com.solutionsone.mic.productservice.infrastructure.kafka.config;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class KafkaStreamsProcessor {

    @Bean
    public KStream<String, String> processKafkaStreams(StreamsBuilder streamsBuilder) {
        // Lee desde múltiples tópicos
        String[] topics = {"topic1", "topic2", "topic3"};

        // Crear un KStream que lea desde varios tópicos
        KStream<String, String> stream = streamsBuilder.stream(Arrays.asList(topics));

        // Definir la lógica de procesamiento para los mensajes
        stream.foreach((key, value) -> {
            System.out.println("Procesando mensaje: Key=" + key + ", Value=" + value);
        });

        // Puedes agregar más lógica de procesamiento aquí (filtros, mapeos, etc.)
        return stream;
    }
}
