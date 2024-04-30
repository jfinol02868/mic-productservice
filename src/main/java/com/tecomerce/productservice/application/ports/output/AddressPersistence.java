package com.tecomerce.productservice.application.ports.output;

import com.tecomerce.productservice.domain.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressPersistence {

    Optional<Address> findById(String id);
    List<Address> findAll();
    Address save(Address address);
    void deleteById(String id);
}
