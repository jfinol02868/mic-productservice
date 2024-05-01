package com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper;

import com.tecomerce.productservice.domain.model.Category;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.CategoryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryDTOMapper {

    public CategoryDTO toDTO(Category category);

    public Category toModel(CategoryDTO categoryDTO);

    public  List<CategoryDTO> toDTOList(List<Category> categories);

    public List<Category> toModelList(List<CategoryDTO> categoryDTOS);

}
