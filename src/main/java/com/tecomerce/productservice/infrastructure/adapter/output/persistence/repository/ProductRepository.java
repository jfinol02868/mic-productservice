package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository;

import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
