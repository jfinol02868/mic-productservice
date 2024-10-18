package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository;

import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepositoryAdapter extends JpaRepository<BrandEntity, String> {
}
