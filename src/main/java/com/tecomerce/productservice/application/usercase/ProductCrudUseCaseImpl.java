package com.tecomerce.productservice.application.usercase;

import com.tecomerce.productservice.application.ports.input.ProductCrudUseCase;
import com.tecomerce.productservice.application.ports.output.ProductPersistence;
import com.tecomerce.productservice.domain.exception.EntityNotFoundException;
import com.tecomerce.productservice.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCrudUseCaseImpl implements ProductCrudUseCase {

    private final ProductPersistence productRepository;

    public ProductCrudUseCaseImpl(ProductPersistence productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(String id, Product product) {
        return productRepository.findById(id).map(p -> {
            p.setId(id);
            p.setProductName(product.getProductName());
            p.setProductDescription(product.getProductDescription());
            p.setProductStock(product.getProductStock());
            p.setProductAvailability(product.getProductAvailability());
            p.setProductWeight(product.getProductWeight());
            return productRepository.save(p);
        }).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(String id) {
        productRepository.findById(id).ifPresentOrElse( p -> {
            productRepository.deleteById(p.getId());
        }, () -> { throw new EntityNotFoundException(); });
    }
}
