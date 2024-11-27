package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository;

import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BrandRepositoryAdapter extends JpaRepository<BrandEntity, Long> , JpaSpecificationExecutor<BrandEntity> {

}
