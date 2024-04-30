package com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private String street;
    private String number;
    private String city;
    private String country;
    private String postalCode;



}
