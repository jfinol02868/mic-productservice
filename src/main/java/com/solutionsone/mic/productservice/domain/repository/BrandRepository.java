package com.solutionsone.mic.productservice.domain.repository;

import com.solutionsone.mic.productservice.domain.entity.Brand;

import java.util.List;

public interface BrandRepository {

    default List<Brand> findAll() { return List.of(); }
}
