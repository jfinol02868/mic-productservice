package com.tecomerce.productservice.application.usercase;

import com.tecomerce.productservice.application.ports.input.AddressCrudUseCase;
import com.tecomerce.productservice.application.ports.output.AddressPersistence;
import com.tecomerce.productservice.domain.exception.EntityNotFoundException;
import com.tecomerce.productservice.domain.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressCrudUseCaseImpl implements AddressCrudUseCase {

    private final AddressPersistence persistence;

    public AddressCrudUseCaseImpl(AddressPersistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public Address findById(String id) {
        return persistence.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Address> findAll() {
        return persistence.findAll();
    }

    @Override
    public Address save(Address value) {
        return persistence.save(value);
    }

    @Override
    public Address update(String id, Address value) {
        return persistence.findById(id).map( a -> {
            a.setId(id);
            a.setStreet(value.getStreet());
            a.setNumber(value.getNumber());
            a.setCountry(value.getCountry());
            a.setCity(value.getCity());
            a.setPostalCode(value.getPostalCode());
            return persistence.save(a);
        }) .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteById(String id) {
        persistence.findById(id).ifPresentOrElse( a -> {
            persistence.deleteById(a.getId());
        }, () -> {throw new EntityNotFoundException();});
    }
}
