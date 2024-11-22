package com.solutionsone.mic.productservice.infrastructure.bd.kafka;

import com.solutionsone.mic.productservice.domain.entity.Product2;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProductStreamProcessor {

    @Bean
    public KStream<String, Product2> processStream(org.apache.kafka.streams.StreamsBuilder streamsBuilder) {
        Map<String, String> serdeConfig = new HashMap<>();
        serdeConfig.put("schema.registry.url", "http://localhost:8081");

        SpecificAvroSerde<Product2> productSerde = new SpecificAvroSerde<>();
        productSerde.configure(serdeConfig, false);

        // Leer mensajes del tópico de entrada
        KStream<String, Product2> inputStream = streamsBuilder.stream("products-input");

        // Procesar mensajes
        KStream<String, Product2> transformedStream = inputStream.mapValues(product -> {
            product.setName(product.getName().toUpperCase());
            return product;
        });

        // Escribir mensajes transformados al tópico de salida
        transformedStream.to("products-output", Produced.with(Serdes.String(), productSerde));

        return transformedStream;
    }
}
