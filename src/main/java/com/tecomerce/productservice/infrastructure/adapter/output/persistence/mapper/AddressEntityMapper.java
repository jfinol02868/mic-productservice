package com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper;

import com.tecomerce.productservice.domain.model.Address;
import com.tecomerce.productservice.domain.model.Category;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.AddressEntity;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressEntityMapper {

    public AddressEntity toEntity(Address address);

    public Address toModel(AddressEntity addressEntity);

    public List<AddressEntity> toEntityList(List<Address> addresses);

    public List<Address> toModelList(List<AddressEntity> addressEntities);
}
