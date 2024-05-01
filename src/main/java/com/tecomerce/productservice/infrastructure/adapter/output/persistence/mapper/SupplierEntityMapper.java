package com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper;

import com.tecomerce.productservice.domain.model.Supplier;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.SupplierEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface SupplierEntityMapper {

    SupplierEntity toEntity(Supplier supplier);

    Supplier toModel(SupplierEntity supplier);

    List<SupplierEntity> toEntityList(List<Supplier> suppliers);

    List<Supplier> toModelList(List<SupplierEntity> supplierEntities);
}
