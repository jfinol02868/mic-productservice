package com.tecomerce.productservice.application.usercase;

import com.tecomerce.productservice.application.ports.input.ProductCrudUseCase;
import com.tecomerce.productservice.application.ports.output.ProductPersistence;
import com.tecomerce.productservice.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product value) {
        return productRepository.save(value);
    }

    @Override
    public Product update(String id, Product value) {
        Product  product = productRepository.findById(id);
        if(Objects.isNull(product)) {
            System.out.println("El registro es nulo.");
        }
        BeanUtils.copyProperties(value, product);
        return productRepository.save(product);
    }

    @Override
    public Void deleteById(String id) {
        return productRepository.deleteById(id);
    }
}
