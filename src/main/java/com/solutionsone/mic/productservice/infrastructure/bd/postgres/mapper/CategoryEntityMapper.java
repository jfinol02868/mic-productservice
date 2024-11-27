package com.solutionsone.mic.productservice.infrastructure.bd.postgres.mapper;

import com.solutionsone.mic.productservice.domain.entity.Category;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    Category toModel(CategoryEntity categoryEntity);

    CategoryEntity toEntity(Category category);

    List<Category> toModelList(List<CategoryEntity> categoryEntityList);

    List<CategoryEntity> toEntityList(List<Category> categoryList);
}
