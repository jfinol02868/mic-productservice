package com.tecomerce.productservice.application.usercase;

import com.tecomerce.productservice.application.ports.input.AddressCrudUseCase;
import com.tecomerce.productservice.application.ports.output.AddressPersistence;
import com.tecomerce.productservice.domain.exception.EntityNotFoundException;
import com.tecomerce.productservice.domain.model.Address;
import org.springframework.beans.BeanUtils;
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
        Address address = persistence.findById(id).orElseThrow(EntityNotFoundException::new);
        BeanUtils.copyProperties(value, address);
        return persistence.save(address);
    }

    @Override
    public void deleteById(String id) {
        persistence.findById(id).ifPresentOrElse( a -> {
            persistence.deleteById(a.getId());
        }, () -> {throw new EntityNotFoundException();});
    }
}