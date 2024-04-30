package com.tecomerce.productservice.domain.model;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String id;
    private String street;
    private String number;
    private String city;
    private String country;
    private String postalCode;
}
