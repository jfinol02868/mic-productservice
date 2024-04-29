package com.tecomerce.productservice.application.usercase;

import com.tecomerce.productservice.application.ports.input.ProductUseCase;
import com.tecomerce.productservice.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCaseImpl implements ProductUseCase {

    @Override
    public List<Product> findAll() {
        return ProductUseCase.super.findAll();
    }
}
