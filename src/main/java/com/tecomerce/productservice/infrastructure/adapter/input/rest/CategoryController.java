package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.application.ports.input.CategoryCrudUseCase;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper.CategoryDTOMapper;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.CategoryApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.CategoryDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Categories")
@RequestMapping("/v1/categories")
public class CategoryController implements CategoryApi {

    private final  CategoryDTOMapper mapper;
    private final CategoryCrudUseCase useCase;

    public CategoryController(CategoryDTOMapper mapper, CategoryCrudUseCase useCase) {
        this.mapper = mapper;
        this.useCase = useCase;
    }

    @Override
    public ResponseEntity<CategoryDTO> create(CategoryDTO categoryDTO) {
        return new ResponseEntity<>(mapper.toDTO(useCase.save(mapper.toModel(categoryDTO))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryDTO> findById(String id) {
        return new ResponseEntity<>(mapper.toDTO(useCase.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> findAll() {
        return new ResponseEntity<>(mapper.toDTOList(useCase.findAll()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDTO> update(CategoryDTO categoryDTO, String id) {
        return new ResponseEntity<>(mapper.toDTO(useCase.update(id, mapper.toModel(categoryDTO))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        useCase.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
