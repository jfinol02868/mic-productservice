package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.impl;

import com.tecomerce.productservice.application.ports.output.ProductRepository;
import com.tecomerce.productservice.domain.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductEntityRepositoryImpl implements ProductRepository {


    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
