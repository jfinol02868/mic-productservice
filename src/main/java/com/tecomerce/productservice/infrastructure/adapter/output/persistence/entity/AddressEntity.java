package com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name =  "address")
public class AddressEntity {

    @Id
    private String  id;
    private String street;
    private String number;
    private String city;
    private String country;
    private String postalCode;
}
