package com.tecomerce.productservice.application.ports.output;

import com.tecomerce.productservice.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductPersistence {

    Optional<Product> findById(String id);

    List<Product> findAll();

    Product save(Product product);

    void deleteById(String id);
}
