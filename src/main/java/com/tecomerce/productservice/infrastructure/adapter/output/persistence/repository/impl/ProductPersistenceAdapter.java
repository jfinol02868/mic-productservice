package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.impl;

import com.tecomerce.productservice.application.ports.output.ProductPersistence;
import com.tecomerce.productservice.domain.model.Product;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper.ProductEntityMapper;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public class ProductPersistenceAdapter implements ProductPersistence {

    private final ProductRepository repository;
    private final ProductEntityMapper mapper;

    public ProductPersistenceAdapter(ProductRepository repository, ProductEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Product> findById(String id) {
        return repository.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Product save(Product product) {
        product.setId(UUID.randomUUID().toString());
        return mapper.toModel(repository.save(mapper.toEntity(product)));
    }

    @Override
    public void deleteById(String id) {
        repository.findById(id);
    }
}
