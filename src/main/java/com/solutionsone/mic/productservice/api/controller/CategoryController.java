package com.solutionsone.mic.productservice.api.controller;

import com.solutionsone.mic.productservice.api.service.dto.CategoryDto;
import com.solutionsone.mic.productservice.api.service.dto.SortEnumDTO;
import com.solutionsone.mic.productservice.api.service.CategoryApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/categories")
@Tags(value = {@Tag(name = "Category", description = "Category API")})
public class CategoryController implements CategoryApi<CategoryDto> {

    @Override
    public ResponseEntity<CategoryDto> create(CategoryDto entity) {
        return CategoryApi.super.create(entity);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> createAll(List<CategoryDto> entities) {
        return CategoryApi.super.createAll(entities);
    }

    @Override
    public ResponseEntity<CategoryDto> update(CategoryDto entity, Long id) {
        return CategoryApi.super.update(entity, id);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> updateAll(List<CategoryDto> entities) {
        return CategoryApi.super.updateAll(entities);
    }

    @Override
    public ResponseEntity<CategoryDto> findById(Long id) {
        return CategoryApi.super.findById(id);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> findByIds(List<Long> ids) {
        return CategoryApi.super.findByIds(ids);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return CategoryApi.super.delete(id);
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<Long> ids) {
        return CategoryApi.super.deleteAll(ids);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return CategoryApi.super.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> filters(String filterProperties, int page, int size, SortEnumDTO direction, String... sortProperties) {
        return CategoryApi.super.filters(filterProperties, page, size, direction, sortProperties);
    }
}
