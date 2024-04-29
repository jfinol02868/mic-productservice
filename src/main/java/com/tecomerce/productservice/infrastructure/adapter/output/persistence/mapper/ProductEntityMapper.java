package com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper;


import com.tecomerce.productservice.domain.model.Product;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    public ProductEntity toEntity(Product value);

    public Product toModel(ProductEntity value);

    public List<ProductEntity> toEntityList(List<Product> values);

    public List<Product> toModelList(List<ProductEntity> values);
}
