package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository;

import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, String> {
}
