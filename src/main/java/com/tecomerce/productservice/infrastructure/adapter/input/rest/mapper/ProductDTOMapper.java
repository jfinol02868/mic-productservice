package com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper;

import com.tecomerce.productservice.domain.model.Product;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper {

    public ProductDTO toDTO(Product value);

    public Product toModel(ProductDTO value);

    public  List<ProductDTO> toDTOList(List<Product> values);

    public List<Product> toModelList(List<ProductDTO> value);

}
