package com.solutionsone.mic.productservice.application.usercase;

import com.solutionsone.mic.productservice.domain.entity.Brand;

import java.util.List;

public interface BrandUserCase {

    default List<Brand> findAll() { return List.of(); }
}
