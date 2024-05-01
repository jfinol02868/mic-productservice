package com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper;

import com.tecomerce.productservice.domain.model.Category;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.CategoryDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-01T22:17:50+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Private Build)"
)
@Component
public class CategoryDTOMapperImpl implements CategoryDTOMapper {

    @Override
    public CategoryDTO toDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO.CategoryDTOBuilder categoryDTO = CategoryDTO.builder();

        categoryDTO.id( category.getId() );
        categoryDTO.categoryName( category.getCategoryName() );
        categoryDTO.categoryDescription( category.getCategoryDescription() );
        categoryDTO.categoryParent( category.getCategoryParent() );
        List<String> list = category.getCategoryUrlImages();
        if ( list != null ) {
            categoryDTO.categoryUrlImages( new ArrayList<String>( list ) );
        }
        categoryDTO.categoryStatus( category.getCategoryStatus() );
        List<String> list1 = category.getCategoryLabels();
        if ( list1 != null ) {
            categoryDTO.categoryLabels( new ArrayList<String>( list1 ) );
        }
        categoryDTO.categoryCreationDate( category.getCategoryCreationDate() );
        categoryDTO.categoryUpdateDate( category.getCategoryUpdateDate() );

        return categoryDTO.build();
    }

    @Override
    public Category toModel(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.id( categoryDTO.getId() );
        category.categoryName( categoryDTO.getCategoryName() );
        category.categoryDescription( categoryDTO.getCategoryDescription() );
        category.categoryParent( categoryDTO.getCategoryParent() );
        category.categoryCreationDate( categoryDTO.getCategoryCreationDate() );
        category.categoryUpdateDate( categoryDTO.getCategoryUpdateDate() );
        List<String> list = categoryDTO.getCategoryUrlImages();
        if ( list != null ) {
            category.categoryUrlImages( new ArrayList<String>( list ) );
        }
        category.categoryStatus( categoryDTO.getCategoryStatus() );
        List<String> list1 = categoryDTO.getCategoryLabels();
        if ( list1 != null ) {
            category.categoryLabels( new ArrayList<String>( list1 ) );
        }

        return category.build();
    }

    @Override
    public List<CategoryDTO> toDTOList(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( categories.size() );
        for ( Category category : categories ) {
            list.add( toDTO( category ) );
        }

        return list;
    }

    @Override
    public List<Category> toModelList(List<CategoryDTO> categoryDTOS) {
        if ( categoryDTOS == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryDTOS.size() );
        for ( CategoryDTO categoryDTO : categoryDTOS ) {
            list.add( toModel( categoryDTO ) );
        }

        return list;
    }
}
