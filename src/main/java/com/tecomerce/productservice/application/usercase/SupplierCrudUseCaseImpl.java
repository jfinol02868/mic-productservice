package com.tecomerce.productservice.application.usercase;

import com.tecomerce.productservice.application.ports.input.SupplierCrudUseCase;
import com.tecomerce.productservice.application.ports.output.SupplierPersistence;
import com.tecomerce.productservice.domain.exception.EntityNotFoundException;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierCrudUseCaseImpl implements SupplierCrudUseCase {

    private final SupplierPersistence persistence;

    public SupplierCrudUseCaseImpl(SupplierPersistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public Supplier findById(String id) {
        return persistence.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Supplier> findAll() {
        return persistence.findAll();
    }

    @Override
    public Supplier save(Supplier value) {
        return persistence.save(value);
    }

    @Override
    public Supplier update(String id, Supplier value) {
        return persistence.findById(id).map( s -> {
            return persistence.save(Supplier.builder()
                    .id(s.getId())
                    .supplierName(value.getSupplierName())
                    .supplierDescription(value.getSupplierDescription())
                    .supplierEmail(value.getSupplierEmail())
                    .supplierPhone(value.getSupplierPhone())
                    .productsSupplied(value.getProductsSupplied())
                    .supplierStatus(value.getSupplierStatus())
                    .build());
        }).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(String id) {
        persistence.deleteById(id);
    }
}
