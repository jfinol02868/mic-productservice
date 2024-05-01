package com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

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
    @NotNull(message = "Field street cannot be empty or null.")
    private String street;

    @Schema(example = "20")
    @NotNull(message = "Field number cannot be empty or null.")
    private String number;

    @Schema(example = "Zaragoza")
    @NotNull(message = "Field city cannot be empty or null.")
    private String city;

    @Schema(example = "Spain")
    @NotNull(message = "Field country cannot be empty or null.")
    private String country;

    @Schema(example = "50008")
    @NotNull(message = "Field postal code cannot be empty or null.")
    private String postalCode;



}
