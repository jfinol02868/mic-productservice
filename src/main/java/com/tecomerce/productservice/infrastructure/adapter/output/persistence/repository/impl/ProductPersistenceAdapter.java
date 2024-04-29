package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.impl;

import com.tecomerce.productservice.application.ports.output.ProductPersistence;
import com.tecomerce.productservice.domain.model.Product;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper.ProductEntityMapper.PRODUCT_ENTITY_MAPPER;

@Service
public class ProductPersistenceAdapter implements ProductPersistence {

    private final ProductRepository productEntityRepository;

    public ProductPersistenceAdapter(ProductRepository productEntityRepository) {
        this.productEntityRepository = productEntityRepository;
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return PRODUCT_ENTITY_MAPPER.toModels(productEntityRepository.findAll());
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
