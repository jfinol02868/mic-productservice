package com.solutionsone.mic.productservice.application.usercase.impl;

import com.solutionsone.mic.productservice.application.usercase.BrandUserCase;
import com.solutionsone.mic.productservice.domain.entity.Brand;
import com.solutionsone.mic.productservice.domain.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandUseCaseImpl implements BrandUserCase {

    private final BrandRepository repository;

    @Override
    public List<Brand> findAll() {
        return repository.findAll();
    }
}
