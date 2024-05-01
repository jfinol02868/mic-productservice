package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.impl;

import com.tecomerce.productservice.application.ports.output.CategoryPersistence;
import com.tecomerce.productservice.domain.model.Category;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper.CategoryEntityMapper;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CategoryPersistenceAdapter implements CategoryPersistence {

    private final CategoryRepository repository;
    private final CategoryEntityMapper mapper;

    public CategoryPersistenceAdapter(CategoryRepository repository, CategoryEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Category> findById(String id) {
        return repository.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Category save(Category category) {
        return mapper.toModel(repository.save(mapper.toEntity(category)));
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
