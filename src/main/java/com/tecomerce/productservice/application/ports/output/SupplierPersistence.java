package com.tecomerce.productservice.application.ports.output;


import com.tecomerce.productservice.domain.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierPersistence {

    Optional<Supplier> findById(String id);

    List<Supplier> findAll();

    Supplier save(Supplier supplier);

    void deleteById(String id);
}
