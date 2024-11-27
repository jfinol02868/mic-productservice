package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.impl;

import com.solutionsone.mic.productservice.domain.entity.Category;
import com.solutionsone.mic.productservice.domain.exception.EntityNotFoundException;
import com.solutionsone.mic.productservice.domain.exception.PersistErrorException;
import com.solutionsone.mic.productservice.domain.repository.CategoryRepository;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.mapper.CategoryEntityMapper;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.CategoryRepositoryAdapter;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.solutionsone.mic.productservice.domain.util.Message.BRAND_NOT_FOUND;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryEntityMapper mapper;
    private final CategoryRepositoryAdapter repository;

    public CategoryRepositoryImpl(CategoryEntityMapper mapper, CategoryRepositoryAdapter repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Category create(Category entity) {
        return mapper.toModel(repository.save(mapper.toEntity(entity)));
    }

    @Override
    @Transactional(rollbackOn = PersistErrorException.class)
    public List<Category> createAll(List<Category> entities) {
        return mapper.toModelList(repository.saveAll(mapper.toEntityList(entities)));
    }

    @Override
    public Category update(Category entity, Long id) {
        Category category = this.findById(id);
        entity.setId(id);
        BeanUtils.copyProperties(entity, category);
        return mapper.toModel(repository.save(mapper.toEntity(category)));
    }

    @Override
    @Transactional(rollbackOn = PersistErrorException.class)
    public List<Category> updateAll(List<Category> entities) {
        return CategoryRepository.super.updateAll(entities);
    }

    @Override
    public Category findById(Long id) {
        return mapper.toModel(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException(BRAND_NOT_FOUND.getCode(), String.format(BRAND_NOT_FOUND.getValue(), id))));
    }

    @Override
    public List<Category> findByIds(List<Long> ids) {
        return mapper.toModelList(repository.findAllById(ids));
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }

    @Override
    @Transactional(rollbackOn = PersistErrorException.class)
    public void deleteAll(List<Long> ids) {
        ids.forEach(this::findById);
        repository.deleteAllById(ids);
    }

    @Override
    public List<Category> findAllPaginated(int page, int size, String sort, String direction) {
        return CategoryRepository.super.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public List<Category> filters(Category object, int page, int size, String direction, String... sortProperties) {
        return CategoryRepository.super.filters(object, page, size, direction, sortProperties);
    }
}
