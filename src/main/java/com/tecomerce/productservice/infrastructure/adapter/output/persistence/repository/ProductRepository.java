package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository;

import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
