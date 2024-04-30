package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository;

import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
}
