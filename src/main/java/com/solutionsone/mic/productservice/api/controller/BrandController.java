package com.solutionsone.mic.productservice.api.controller;

import com.solutionsone.mic.productservice.api.service.BrandApi;
import com.solutionsone.mic.productservice.api.service.dto.BrandDto;
import com.solutionsone.mic.productservice.api.service.dto.SortEnumDTO;
import com.solutionsone.mic.productservice.api.service.mapper.BrandDtoMapper;
import com.solutionsone.mic.productservice.application.usercase.BrandUserCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/brands")
@Tags(value = {@Tag(name = "Brand", description = "Brand API")})
public class BrandController implements BrandApi {

    private final BrandUserCase useCase;
    private final BrandDtoMapper mapper;

    @Override
    public ResponseEntity<BrandDto> create(BrandDto entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(mapper.toModel(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<BrandDto>> createAll(List<BrandDto> entities) {
        return BrandApi.super.createAll(entities);
    }

    @Override
    public ResponseEntity<BrandDto> update(BrandDto entity, String id) {
        return BrandApi.super.update(entity, id);
    }

    @Override
    public ResponseEntity<List<BrandDto>> updateAll(List<BrandDto> entities) {
        return BrandApi.super.updateAll(entities);
    }

    @Override
    public ResponseEntity<BrandDto> findById(String id) {
        return BrandApi.super.findById(id);
    }

    @Override
    public ResponseEntity<List<BrandDto>> findByIds(List<String> id) {
        return BrandApi.super.findByIds(id);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return BrandApi.super.delete(id);
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<String> ids) {
        return BrandApi.super.deleteAll(ids);
    }

    @Override
    public ResponseEntity<List<BrandDto>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return BrandApi.super.findAllPaginated(page, size, sort, direction);
    }

    @Override
    public ResponseEntity<List<BrandDto>> filters(String filterProperties, int page, int size, SortEnumDTO direction,
                                                  String... sortProperties) {
        return new ResponseEntity<>(
                mapper.toDtoList(useCase.filters(filterProperties, page, size, direction.getValue(), sortProperties))
                , HttpStatus.OK);
    }
}
