package com.tecomerce.productservice.application.usercase;

import com.tecomerce.productservice.application.ports.input.CategoryCrudUseCase;
import com.tecomerce.productservice.application.ports.output.CategoryPersistence;
import com.tecomerce.productservice.domain.exception.EntityNotFoundException;
import com.tecomerce.productservice.domain.model.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryCrudUseCaseImpl implements CategoryCrudUseCase {

    private final CategoryPersistence persistence;


    public CategoryCrudUseCaseImpl(CategoryPersistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public Category findById(String id) {
        return persistence.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Category> findAll() {
        return persistence.findAll();
    }

    @Override
    public Category save(Category category) {
        return persistence.save(category);
    }

    @Override
    public Category update(String id, Category category) {
        Category categoryResponse = persistence.findById(id).orElseThrow(EntityNotFoundException::new);
        BeanUtils.copyProperties(category, categoryResponse);
        return persistence.save(categoryResponse);
    }

    @Override
    public void deleteById(String id) {
        persistence.findById(id).ifPresentOrElse( c -> {
             persistence.deleteById(c.getId());
        }, () -> { throw new EntityNotFoundException();});
    }
}
