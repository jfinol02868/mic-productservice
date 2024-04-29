package com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper;


import com.tecomerce.productservice.domain.model.Product;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductEntityMapper {

    final static ProductEntityMapper PRODUCT_ENTITY_MAPPER = Mappers.getMapper(ProductEntityMapper.class);

    public ProductEntity toEntity(Product value);

    public Product toModel(ProductEntity value);

    public List<ProductEntity> toEntities(List<Product> values);

    public List<Product> toModels(List<ProductEntity> values);
}
