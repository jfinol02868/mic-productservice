package com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper;

import com.tecomerce.productservice.domain.model.Category;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.CategoryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-01T21:32:58+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Private Build)"
)
@Component
public class CategoryEntityMapperImpl implements CategoryEntityMapper {

    @Override
    public CategoryEntity toEntity(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.id( category.getId() );
        categoryEntity.categoryName( category.getCategoryName() );
        categoryEntity.categoryDescription( category.getCategoryDescription() );
        categoryEntity.categoryParent( category.getCategoryParent() );
        categoryEntity.categoryCreationDate( category.getCategoryCreationDate() );
        categoryEntity.categoryUpdateDate( category.getCategoryUpdateDate() );
        List<String> list = category.getCategoryUrlImages();
        if ( list != null ) {
            categoryEntity.categoryUrlImages( new ArrayList<String>( list ) );
        }
        categoryEntity.categoryStatus( category.getCategoryStatus() );
        List<String> list1 = category.getCategoryLabels();
        if ( list1 != null ) {
            categoryEntity.categoryLabels( new ArrayList<String>( list1 ) );
        }

        return categoryEntity.build();
    }

    @Override
    public Category toModel(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.id( categoryEntity.getId() );
        category.categoryName( categoryEntity.getCategoryName() );
        category.categoryDescription( categoryEntity.getCategoryDescription() );
        category.categoryParent( categoryEntity.getCategoryParent() );
        category.categoryCreationDate( categoryEntity.getCategoryCreationDate() );
        category.categoryUpdateDate( categoryEntity.getCategoryUpdateDate() );
        List<String> list = categoryEntity.getCategoryUrlImages();
        if ( list != null ) {
            category.categoryUrlImages( new ArrayList<String>( list ) );
        }
        category.categoryStatus( categoryEntity.getCategoryStatus() );
        List<String> list1 = categoryEntity.getCategoryLabels();
        if ( list1 != null ) {
            category.categoryLabels( new ArrayList<String>( list1 ) );
        }

        return category.build();
    }

    @Override
    public List<CategoryEntity> toEntityList(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryEntity> list = new ArrayList<CategoryEntity>( categories.size() );
        for ( Category category : categories ) {
            list.add( toEntity( category ) );
        }

        return list;
    }

    @Override
    public List<Category> toModelList(List<CategoryEntity> categoryEntities) {
        if ( categoryEntities == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryEntities.size() );
        for ( CategoryEntity categoryEntity : categoryEntities ) {
            list.add( toModel( categoryEntity ) );
        }

        return list;
    }
}
