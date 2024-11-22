package com.solutionsone.mic.productservice;

import com.solutionsone.mic.productservice.api.service.dto.BrandDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String CLASS_NAME_BRAND = BrandDto.class.getCanonicalName();
		System.out.println(CLASS_NAME_BRAND);
	}
}
