package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.impl;

import com.tecomerce.productservice.application.ports.output.AddressPersistence;
import com.tecomerce.productservice.domain.model.Address;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper.AddressEntityMapper;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository.AddressRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AddressPersistenceAdapter implements AddressPersistence {

    private final AddressRepository repository;
    private final AddressEntityMapper mapper;

    public AddressPersistenceAdapter(AddressRepository repository, AddressEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Address> findById(String id) {
        return repository.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Address> findAll() {
        return repository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Address save(Address address) {
        return mapper.toModel(repository.save(mapper.toEntity(address)));
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
