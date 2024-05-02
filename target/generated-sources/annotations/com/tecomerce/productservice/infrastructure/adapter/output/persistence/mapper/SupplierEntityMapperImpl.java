package com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper;

import com.tecomerce.productservice.domain.model.Supplier;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.SupplierEntity;
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
public class SupplierEntityMapperImpl implements SupplierEntityMapper {

    @Override
    public SupplierEntity toEntity(Supplier supplier) {
        if ( supplier == null ) {
            return null;
        }

        SupplierEntity.SupplierEntityBuilder supplierEntity = SupplierEntity.builder();

        supplierEntity.id( supplier.getId() );
        supplierEntity.supplierName( supplier.getSupplierName() );
        supplierEntity.supplierEmail( supplier.getSupplierEmail() );
        supplierEntity.supplierPhone( supplier.getSupplierPhone() );
        supplierEntity.supplierStatus( supplier.getSupplierStatus() );
        supplierEntity.productsSupplied( supplier.getProductsSupplied() );
        supplierEntity.supplierDescription( supplier.getSupplierDescription() );

        return supplierEntity.build();
    }

    @Override
    public Supplier toModel(SupplierEntity supplier) {
        if ( supplier == null ) {
            return null;
        }

        Supplier.SupplierBuilder supplier1 = Supplier.builder();

        supplier1.id( supplier.getId() );
        supplier1.supplierName( supplier.getSupplierName() );
        supplier1.supplierEmail( supplier.getSupplierEmail() );
        supplier1.supplierPhone( supplier.getSupplierPhone() );
        supplier1.supplierStatus( supplier.getSupplierStatus() );
        supplier1.productsSupplied( supplier.getProductsSupplied() );
        supplier1.supplierDescription( supplier.getSupplierDescription() );

        return supplier1.build();
    }

    @Override
    public List<SupplierEntity> toEntityList(List<Supplier> suppliers) {
        if ( suppliers == null ) {
            return null;
        }

        List<SupplierEntity> list = new ArrayList<SupplierEntity>( suppliers.size() );
        for ( Supplier supplier : suppliers ) {
            list.add( toEntity( supplier ) );
        }

        return list;
    }

    @Override
    public List<Supplier> toModelList(List<SupplierEntity> supplierEntities) {
        if ( supplierEntities == null ) {
            return null;
        }

        List<Supplier> list = new ArrayList<Supplier>( supplierEntities.size() );
        for ( SupplierEntity supplierEntity : supplierEntities ) {
            list.add( toModel( supplierEntity ) );
        }

        return list;
    }
}
