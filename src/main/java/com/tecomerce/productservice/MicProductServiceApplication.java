package com.tecomerce.productservice;

import com.tecomerce.productservice.infrastructure.bd.model.entity.ProductEntity;
import com.tecomerce.productservice.infrastructure.bd.model.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MicProductServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(MicProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
