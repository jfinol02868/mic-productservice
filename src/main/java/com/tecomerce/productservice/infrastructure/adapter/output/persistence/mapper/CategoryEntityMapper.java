package com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper;

import com.tecomerce.productservice.domain.model.Category;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    public CategoryEntity toEntity(Category category);

    public Category toModel(CategoryEntity categoryEntity);

    public List<CategoryEntity> toEntityList(List<Category> categories);

    public List<Category> toModelList(List<CategoryEntity> categoryEntities);
}
