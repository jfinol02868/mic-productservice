package com.tecomerce.productservice;

import com.tecomerce.productservice.infrastructure.bd.model.entity.ProductEntity;
import com.tecomerce.productservice.infrastructure.bd.model.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MicProductServiceApplication implements CommandLineRunner {

	private final ProductRepository productRepository;

    public MicProductServiceApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(MicProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProductEntity> products = productRepository.findAll();

		products.forEach( p -> p.toString());
	}
}
