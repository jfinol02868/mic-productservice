package com.tecomerce.productservice.application.ports.output;

import com.tecomerce.productservice.domain.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    Optional<Product> findById(Long id);
    List<Product> findAll();
    Product save(Product product);
    void deleteById(UUID id);
}
