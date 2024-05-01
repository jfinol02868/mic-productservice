package com.tecomerce.productservice.infrastructure.adapter.input.rest.mapper;

import com.tecomerce.productservice.domain.model.Address;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.AddressDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-02T00:53:55+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Private Build)"
)
@Component
public class AddressDTOMapperImpl implements AddressDTOMapper {

    @Override
    public AddressDTO toDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO.AddressDTOBuilder addressDTO = AddressDTO.builder();

        addressDTO.id( address.getId() );
        addressDTO.street( address.getStreet() );
        addressDTO.number( address.getNumber() );
        addressDTO.city( address.getCity() );
        addressDTO.country( address.getCountry() );
        addressDTO.postalCode( address.getPostalCode() );

        return addressDTO.build();
    }

    @Override
    public Address toModel(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.id( addressDTO.getId() );
        address.street( addressDTO.getStreet() );
        address.number( addressDTO.getNumber() );
        address.city( addressDTO.getCity() );
        address.country( addressDTO.getCountry() );
        address.postalCode( addressDTO.getPostalCode() );

        return address.build();
    }

    @Override
    public List<AddressDTO> toDTOList(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( toDTO( address ) );
        }

        return list;
    }

    @Override
    public List<Address> toModelList(List<AddressDTO> addressDTOS) {
        if ( addressDTOS == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressDTOS.size() );
        for ( AddressDTO addressDTO : addressDTOS ) {
            list.add( toModel( addressDTO ) );
        }

        return list;
    }
}
