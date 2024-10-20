package com.solutionsone.mic.productservice.api.service.mapper;

import com.solutionsone.mic.productservice.api.service.dto.BrandDto;
import com.solutionsone.mic.productservice.domain.entity.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandDtoMapper {

    BrandDto toModel(Brand brand);

    Brand toDto(BrandDto brandDto);

    List<BrandDto> toDtoList(List<Brand> brands);

    List<Brand> toModelList(List<BrandDto> dtos);
}
