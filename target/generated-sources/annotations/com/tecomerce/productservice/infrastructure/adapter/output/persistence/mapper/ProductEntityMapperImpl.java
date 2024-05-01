package com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper;

import com.tecomerce.productservice.domain.model.Product;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-01T23:05:40+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Private Build)"
)
@Component
public class ProductEntityMapperImpl implements ProductEntityMapper {

    @Override
    public ProductEntity toEntity(Product value) {
        if ( value == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.id( value.getId() );
        productEntity.productName( value.getProductName() );
        productEntity.productDescription( value.getProductDescription() );
        productEntity.productStock( value.getProductStock() );
        productEntity.productWeight( value.getProductWeight() );
        productEntity.productAvailability( value.getProductAvailability() );
        productEntity.productCreationDate( value.getProductCreationDate() );
        productEntity.productUpdateDate( value.getProductUpdateDate() );

        return productEntity.build();
    }

    @Override
    public Product toModel(ProductEntity value) {
        if ( value == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( value.getId() );
        product.productName( value.getProductName() );
        product.productDescription( value.getProductDescription() );
        product.productStock( value.getProductStock() );
        product.productWeight( value.getProductWeight() );
        product.productAvailability( value.getProductAvailability() );
        product.productCreationDate( value.getProductCreationDate() );
        product.productUpdateDate( value.getProductUpdateDate() );

        return product.build();
    }

    @Override
    public List<ProductEntity> toEntityList(List<Product> values) {
        if ( values == null ) {
            return null;
        }

        List<ProductEntity> list = new ArrayList<ProductEntity>( values.size() );
        for ( Product product : values ) {
            list.add( toEntity( product ) );
        }

        return list;
    }

    @Override
    public List<Product> toModelList(List<ProductEntity> values) {
        if ( values == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( values.size() );
        for ( ProductEntity productEntity : values ) {
            list.add( toModel( productEntity ) );
        }

        return list;
    }
}
