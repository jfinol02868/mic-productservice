package com.solutionsone.mic.productservice.application.usecase.brand.impl;

import com.solutionsone.mic.productservice.application.usecase.brand.CategoryUseCase;
import com.solutionsone.mic.productservice.domain.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryUseCaseImpl implements CategoryUseCase {

    @Override
    public List<Category> filters(String filterProperties, int page, int size, String direction, String... sortProperties) {
        return CategoryUseCase.super.filters(filterProperties, page, size, direction, sortProperties);
    }

    @Override
    public Category create(Category entity) {
        return CategoryUseCase.super.create(entity);
    }

    @Override
    public List<Category> createAll(List<Category> entities) {
        return CategoryUseCase.super.createAll(entities);
    }

    @Override
    public Category update(Category entity, Long id) {
        return CategoryUseCase.super.update(entity, id);
    }

    @Override
    public List<Category> updateAll(List<Category> entities) {
        return CategoryUseCase.super.updateAll(entities);
    }

    @Override
    public Category findById(Long id) {
        return CategoryUseCase.super.findById(id);
    }

    @Override
    public List<Category> findByIds(List<Long> id) {
        return CategoryUseCase.super.findByIds(id);
    }

    @Override
    public void delete(Long id) {
        CategoryUseCase.super.delete(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        CategoryUseCase.super.deleteAll(ids);
    }

    @Override
    public List<Category> findAllPaginated(int page, int size, String sort, String direction) {
        return CategoryUseCase.super.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Category> filters(Category object, int page, int size, String direction, String... sortProperties) {
        return CategoryUseCase.super.filters(object, page, size, direction, sortProperties);
    }
}
