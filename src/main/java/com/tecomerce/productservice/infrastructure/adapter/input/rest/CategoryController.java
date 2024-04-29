package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.CategoryApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.CategoryDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Categories")
@RequestMapping("/v1/categories")
public class CategoryController implements CategoryApi {

    @Override
    public ResponseEntity<CategoryDTO> create(CategoryDTO categoryDTO) {
        return CategoryApi.super.create(categoryDTO);
    }

    @Override
    public ResponseEntity<CategoryDTO> findById(String id) {
        return CategoryApi.super.findById(id);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> findAll() {
        return CategoryApi.super.findAll();
    }

    @Override
    public ResponseEntity<CategoryDTO> update(CategoryDTO categoryDTO, String id) {
        return CategoryApi.super.update(categoryDTO, id);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return CategoryApi.super.delete(id);
    }
}
