package com.tecomerce.productservice.application.usercase;

import com.tecomerce.productservice.application.ports.input.ProductCrudUseCase;
import com.tecomerce.productservice.application.ports.output.ProductPersistence;
import com.tecomerce.productservice.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCrudUseCaseImpl implements ProductCrudUseCase {

    private final ProductPersistence productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
}
