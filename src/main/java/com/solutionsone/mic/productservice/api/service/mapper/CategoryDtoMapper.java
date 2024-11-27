package com.solutionsone.mic.productservice.api.service.mapper;

import com.solutionsone.mic.productservice.api.service.dto.CategoryDto;
import com.solutionsone.mic.productservice.domain.entity.Category;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDtoMapper {

    @Mapping(source = "subcategories", target = "subcategories", qualifiedByName = "mapSubcategoriesToIds")
    CategoryDto toDto(Category category);

    @Mapping(source = "subcategories", target = "subcategories", qualifiedByName = "mapIdsToSubcategories")
    Category toEntity(CategoryDto categoryDto);

    List<CategoryDto> toDtoList(List<Category> categories);

    List<Category> toEntityList(List<CategoryDto> dtos);


    @Named("mapSubcategoriesToIds")
    default List<Long> mapSubcategoriesToIds(List<CategoryEntity> subcategories) {
        if (subcategories.isEmpty()) {
            return List.of();
        }
        return subcategories.stream()
                .map(CategoryEntity::getId)
                .toList();
    }

    @Named("mapIdsToSubcategories")
    default List<CategoryEntity> mapIdsToSubcategories(List<Long> subcategoryIds) {
        if (subcategoryIds.isEmpty()) {
            return List.of();
        }
        return subcategoryIds
                .stream()
                .map(id -> CategoryEntity
                        .builder()
                        .id(id)
                        .build())
                .toList();
    }
}
