package com.solutionsone.mic.productservice.api.controller;

import com.solutionsone.mic.productservice.api.service.BrandApi;
import com.solutionsone.mic.productservice.api.service.dto.BrandDto;
import com.solutionsone.mic.productservice.api.service.dto.SortEnumDTO;
import com.solutionsone.mic.productservice.api.service.mapper.BrandDtoMapper;
import com.solutionsone.mic.productservice.application.usecase.brand.BrandUserCase;
import com.solutionsone.mic.productservice.domain.exception.FiledRequireException;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/brands")
@Tags(value = {@Tag(name = "Brand", description = "Brand API")})
public class BrandController implements BrandApi<BrandDto> {

    private final BrandUserCase useCase;
    private final BrandDtoMapper mapper;

    @Override
    public ResponseEntity<BrandDto> create(BrandDto entity) {
        return new ResponseEntity<>(mapper.toDto(useCase.create(mapper.toModel(entity))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<BrandDto>> createAll(List<BrandDto> entities) {
        this.validateFields(entities);
        return new ResponseEntity<>(mapper.toDtoList(useCase.createAll(mapper.toModelList(entities))), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BrandDto> update(BrandDto entity, Long id) {
        return new ResponseEntity<>(mapper.toDto(useCase.update(mapper.toModel(entity), id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BrandDto>> updateAll(List<BrandDto> entities) {
        this.validateFields(entities);
        return new ResponseEntity<>(mapper.toDtoList(useCase.updateAll(mapper.toModelList(entities))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BrandDto> findById(Long id) {
        return new ResponseEntity<>(mapper.toDto(useCase.findById(id)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BrandDto>> findByIds(List<Long> ids) {
        return  new ResponseEntity<>(mapper.toDtoList(useCase.findByIds(ids)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        useCase.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<Long> ids) {
        useCase.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<BrandDto>> findAllPaginated(int page, int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(mapper.toDtoList(useCase.findAllPaginated(page, size, sort, direction.getValue())), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<BrandDto>> filters(String filterProperties, int page, int size, SortEnumDTO direction,
                                                  String... sortProperties) {
        return new ResponseEntity<>(
                mapper.toDtoList(useCase.filters(filterProperties, page, size, direction.getValue(), sortProperties))
                , HttpStatus.OK);
    }

    private void validateFields(List<BrandDto> entities){
        boolean ifNull = entities.stream().anyMatch(e -> Objects.isNull(e.getName()) || Objects.isNull(e.getIsActive()));
        if (ifNull) {
            throw new FiledRequireException(
                    "BF001",
                    "Revisar los campos obligatorios.",
                    List.of("name", "isActive"));
        }
    }
}
