package com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(example = "bc36bacd-b110-4aa3-a083-fe9c5a3404b6")
    private String id;
    @Schema(example = "Pamplona escudero")
    private String street;
    @Schema(example = "20")
    private String number;
    @Schema(example = "Zaragoza")
    private String city;
    @Schema(example = "Spain")
    private String country;
    @Schema(example = "50008")
    private String postalCode;



}
