package com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper;

import com.tecomerce.productservice.domain.model.Product;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductDTOMapper {

    static final ProductDTOMapper PRODUCT_DTO_MAPPER = Mappers.getMapper(ProductDTOMapper.class);

    public ProductDTO toDTO(Product value);

    public Product toModel(ProductDTO value);

    public  List<ProductDTO> toDTOs( List<Product> values);

    public List<Product> toModels( List<ProductDTO> value);

}
