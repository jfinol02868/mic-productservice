package com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper;

import com.tecomerce.productservice.domain.model.Supplier;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.SupplierDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierDTOMapper {

    SupplierDTO toDTO(Supplier supplier);

    Supplier toModel(SupplierDTO supplierDTO);

    List<SupplierDTO> toDTOList(List<Supplier> suppliers);

    List<Supplier> toModelList(List<SupplierDTO> supplierDTOs);

}
