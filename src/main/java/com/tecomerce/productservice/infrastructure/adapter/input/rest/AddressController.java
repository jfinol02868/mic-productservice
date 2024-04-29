package com.tecomerce.productservice.infrastructure.adapter.input.rest;

import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.AddressApi;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.AddressDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Address")
@RequestMapping("/v1/address")
public class AddressController implements AddressApi {

    @Override
    public ResponseEntity<AddressDTO> create(AddressDTO addressDTO) {
        return AddressApi.super.create(addressDTO);
    }

    @Override
    public ResponseEntity<AddressDTO> findById(String id) {
        return AddressApi.super.findById(id);
    }

    @Override
    public ResponseEntity<List<AddressDTO>> findAll() {
        return AddressApi.super.findAll();
    }

    @Override
    public ResponseEntity<AddressDTO> update(AddressDTO addressDTO, String id) {
        return AddressApi.super.update(addressDTO, id);
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        return AddressApi.super.delete(id);
    }
}
