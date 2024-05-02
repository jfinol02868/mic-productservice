package com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper;

import com.tecomerce.productservice.domain.model.Supplier;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.SupplierDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-02T17:57:39+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class SupplierDTOMapperImpl implements SupplierDTOMapper {

    @Override
    public SupplierDTO toDTO(Supplier supplier) {
        if ( supplier == null ) {
            return null;
        }

        SupplierDTO.SupplierDTOBuilder supplierDTO = SupplierDTO.builder();

        supplierDTO.id( supplier.getId() );
        supplierDTO.supplierName( supplier.getSupplierName() );
        supplierDTO.supplierEmail( supplier.getSupplierEmail() );
        supplierDTO.supplierPhone( supplier.getSupplierPhone() );
        supplierDTO.supplierStatus( supplier.getSupplierStatus() );
        supplierDTO.productsSupplied( supplier.getProductsSupplied() );
        supplierDTO.supplierDescription( supplier.getSupplierDescription() );

        return supplierDTO.build();
    }

    @Override
    public Supplier toModel(SupplierDTO supplierDTO) {
        if ( supplierDTO == null ) {
            return null;
        }

        Supplier.SupplierBuilder supplier = Supplier.builder();

        supplier.id( supplierDTO.getId() );
        supplier.supplierName( supplierDTO.getSupplierName() );
        supplier.supplierEmail( supplierDTO.getSupplierEmail() );
        supplier.supplierPhone( supplierDTO.getSupplierPhone() );
        supplier.supplierStatus( supplierDTO.getSupplierStatus() );
        supplier.productsSupplied( supplierDTO.getProductsSupplied() );
        supplier.supplierDescription( supplierDTO.getSupplierDescription() );

        return supplier.build();
    }

    @Override
    public List<SupplierDTO> toDTOList(List<Supplier> suppliers) {
        if ( suppliers == null ) {
            return null;
        }

        List<SupplierDTO> list = new ArrayList<SupplierDTO>( suppliers.size() );
        for ( Supplier supplier : suppliers ) {
            list.add( toDTO( supplier ) );
        }

        return list;
    }

    @Override
    public List<Supplier> toModelList(List<SupplierDTO> supplierDTOs) {
        if ( supplierDTOs == null ) {
            return null;
        }

        List<Supplier> list = new ArrayList<Supplier>( supplierDTOs.size() );
        for ( SupplierDTO supplierDTO : supplierDTOs ) {
            list.add( toModel( supplierDTO ) );
        }

        return list;
    }
}
