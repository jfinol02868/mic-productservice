package com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper;

import com.tecomerce.productservice.domain.model.Address;
import com.tecomerce.productservice.domain.model.Product;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.AddressDTO;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressDTOMapper {

    public AddressDTO toDTO(Address address);

    public Address toModel(AddressDTO addressDTO);

    public  List<AddressDTO> toDTOList( List<Address> addresses);

    public List<Address> toModelList( List<AddressDTO> addressDTOS);

}
