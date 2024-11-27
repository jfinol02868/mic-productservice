package com.solutionsone.mic.productservice.infrastructure.bd.postgres.mapper;

import com.solutionsone.mic.productservice.domain.entity.Brand;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.BrandEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandEntityMapper {

    Brand toModel(BrandEntity brandEntity);

    BrandEntity toEntity(Brand brand);

    List<Brand> toModels(List<BrandEntity> brandEntities);

    List<BrandEntity> toEntities(List<Brand> brands);


}
