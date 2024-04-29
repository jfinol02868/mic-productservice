package com.tecomerce.productservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url = "/v1/products", description = "Base url for the project.")})
public class MicProductServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(MicProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
