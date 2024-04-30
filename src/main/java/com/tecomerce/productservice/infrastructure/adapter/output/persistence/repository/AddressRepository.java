package com.tecomerce.productservice.infrastructure.adapter.output.persistence.repository;

import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, String> {
}
