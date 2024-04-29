package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.impl;

import com.tecomerce.productservice.application.ports.output.ProductPersistence;
import com.tecomerce.productservice.domain.model.Product;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper.ProductEntityMapper.PRODUCT_ENTITY_MAPPER;

@Service
public class ProductPersistenceAdapter implements ProductPersistence {

    private final ProductRepository producRepository;

    public ProductPersistenceAdapter(ProductRepository productEntityRepository) {
        this.producRepository = productEntityRepository;
    }

    @Override
    public Product findById(String id) {
        return PRODUCT_ENTITY_MAPPER.toModel(producRepository.findById(id).get());
    }

    @Override
    public List<Product> findAll() {
        return PRODUCT_ENTITY_MAPPER.toModels(producRepository.findAll());
    }

    @Override
    public Product save(Product product) {
        return PRODUCT_ENTITY_MAPPER.toModel(
                producRepository.save(PRODUCT_ENTITY_MAPPER.toEntity(product)));
    }

    @Override
    public Void deleteById(String id) {
        producRepository.deleteById(id);
        return null;
    }
}
