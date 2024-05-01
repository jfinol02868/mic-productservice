package com.tecomerce.productservice.infrastructure.adapter.output.persistence.mapper;

import com.tecomerce.productservice.domain.model.Address;
import com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity.AddressEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-01T21:32:58+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Private Build)"
)
@Component
public class AddressEntityMapperImpl implements AddressEntityMapper {

    @Override
    public AddressEntity toEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity.AddressEntityBuilder addressEntity = AddressEntity.builder();

        addressEntity.id( address.getId() );
        addressEntity.street( address.getStreet() );
        addressEntity.number( address.getNumber() );
        addressEntity.city( address.getCity() );
        addressEntity.country( address.getCountry() );
        addressEntity.postalCode( address.getPostalCode() );
        addressEntity.addressCreationDate( address.getAddressCreationDate() );

        return addressEntity.build();
    }

    @Override
    public Address toModel(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.id( addressEntity.getId() );
        address.street( addressEntity.getStreet() );
        address.number( addressEntity.getNumber() );
        address.city( addressEntity.getCity() );
        address.country( addressEntity.getCountry() );
        address.postalCode( addressEntity.getPostalCode() );
        address.addressCreationDate( addressEntity.getAddressCreationDate() );

        return address.build();
    }

    @Override
    public List<AddressEntity> toEntityList(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressEntity> list = new ArrayList<AddressEntity>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( toEntity( address ) );
        }

        return list;
    }

    @Override
    public List<Address> toModelList(List<AddressEntity> addressEntities) {
        if ( addressEntities == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressEntities.size() );
        for ( AddressEntity addressEntity : addressEntities ) {
            list.add( toModel( addressEntity ) );
        }

        return list;
    }
}
