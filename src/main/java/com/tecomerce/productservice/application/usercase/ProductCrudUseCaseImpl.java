package com.tecomerce.productservice.application.usercase;

import com.tecomerce.productservice.application.ports.input.ProductCrudUseCase;
import com.tecomerce.productservice.application.ports.output.ProductPersistence;
import com.tecomerce.productservice.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper.ProductEntityMapper.PRODUCT_ENTITY_MAPPER;

@Service
@RequiredArgsConstructor
public class ProductCrudUseCaseImpl implements ProductCrudUseCase {

    private final ProductPersistence productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return  null;

    }

    @Override
    public Product save(Product value) {
        return ProductCrudUseCase.super.save(value);
    }

    @Override
    public Product update(String id, Product value) {
        return ProductCrudUseCase.super.update(id, value);
    }

    @Override
    public Void deleteById(String id) {
        return ProductCrudUseCase.super.deleteById(id);
    }
}
