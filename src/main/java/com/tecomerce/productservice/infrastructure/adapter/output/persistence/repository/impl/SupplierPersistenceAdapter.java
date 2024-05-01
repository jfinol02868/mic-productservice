package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.impl;

import com.tecomerce.productservice.application.ports.output.SupplierPersistence;
import com.tecomerce.productservice.domain.model.Supplier;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper.SupplierEntityMapper;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.SupplierRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SupplierPersistenceAdapter implements SupplierPersistence {

    private final SupplierRepository repository;
    private final SupplierEntityMapper mapper;

    public SupplierPersistenceAdapter(SupplierRepository repository, SupplierEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Optional<Supplier> findById(String id) {
        return repository.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Supplier> findAll() {
        return repository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Supplier save(Supplier supplier) {
        return mapper.toModel(repository.save(mapper.toEntity(supplier)));
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
