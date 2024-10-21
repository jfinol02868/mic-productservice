package com.solutionsone.mic.productservice.application.usercase.impl;

import com.solutionsone.mic.productservice.application.usercase.BrandUserCase;
import com.solutionsone.mic.productservice.domain.entity.Brand;
import com.solutionsone.mic.productservice.domain.repository.BrandRepository;
import com.solutionsone.mic.productservice.domain.util.MapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandUseCaseImpl implements BrandUserCase {

    private final MapperUtil mapperUtil;
    private final BrandRepository repository;

    @Override
    public Brand create(Brand entity) {
        return repository.create(entity);
    }

    @Override
    public List<Brand> filters(String filterProperties, int page, int size, java.lang.String direction, String... sortProperties) {
        Brand brand = (Brand) mapperUtil.mappingEntity(filterProperties, Brand.class);
        return repository.filters(brand, page, size, direction, sortProperties);
    }
}
