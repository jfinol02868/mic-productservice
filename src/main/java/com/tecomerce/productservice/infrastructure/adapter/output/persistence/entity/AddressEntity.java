package com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name =  "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  id;
    private String street;
    private String number;
    private String city;
    private String country;
    private String postalCode;
    private ZonedDateTime addressCreationDate;

    @PrePersist
    private void onCreated() {
        this.addressCreationDate = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
