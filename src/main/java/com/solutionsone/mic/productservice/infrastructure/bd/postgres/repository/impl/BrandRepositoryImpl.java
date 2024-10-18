package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.impl;

import com.solutionsone.mic.productservice.domain.entity.Brand;
import com.solutionsone.mic.productservice.domain.repository.BrandRepository;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.mapper.BrandEntityMapper;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.BrandRepositoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BrandRepositoryImpl implements BrandRepository {

    private final BrandEntityMapper mapper;
    private final BrandRepositoryAdapter repository;

    @Override
    public List<Brand> findAll() {
        return mapper.toModels(repository.findAll());
    }
}
