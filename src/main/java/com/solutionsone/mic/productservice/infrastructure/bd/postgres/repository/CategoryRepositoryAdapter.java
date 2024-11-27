package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository;

import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositoryAdapter extends JpaRepository<CategoryEntity, Long> {
}
