package com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper;

import com.tecomerce.productservice.domain.model.Product;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.ProductDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T23:49:17+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Private Build)"
)
@Component
public class ProductDTOMapperImpl implements ProductDTOMapper {

    @Override
    public ProductDTO toDTO(Product value) {
        if ( value == null ) {
            return null;
        }

        ProductDTO.ProductDTOBuilder productDTO = ProductDTO.builder();

        productDTO.id( value.getId() );
        productDTO.productName( value.getProductName() );
        productDTO.productDescription( value.getProductDescription() );
        productDTO.productStock( value.getProductStock() );
        productDTO.productWeight( value.getProductWeight() );
        productDTO.productAvailability( value.getProductAvailability() );
        productDTO.productCreationDate( value.getProductCreationDate() );
        productDTO.productUpdateDate( value.getProductUpdateDate() );

        return productDTO.build();
    }

    @Override
    public Product toModel(ProductDTO value) {
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
    public List<ProductDTO> toDTOs(List<Product> values) {
        if ( values == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( values.size() );
        for ( Product product : values ) {
            list.add( toDTO( product ) );
        }

        return list;
    }

    @Override
    public List<Product> toModels(List<ProductDTO> value) {
        if ( value == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( value.size() );
        for ( ProductDTO productDTO : value ) {
            list.add( toModel( productDTO ) );
        }

        return list;
    }
}
