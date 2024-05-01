package com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(example = "bc36bacd-b110-4aa3-a083-fe9c5a3404b6")
    private String id;

    @Schema(example = "SAMSUNG")
    @NotNull(message = "Filed supplier name cannot be empty or null.")
    private String supplierName;

    @Schema(example = "samsung@supplier.com")
    @NotNull(message = "Filed supplier email cannot be empty or null.")
    private String supplierEmail;

    @Schema(example = "+ 555 555 555")
    @NotNull(message = "Filed supplier phone cannot be empty or null.")
    private String supplierPhone;

    @Schema(example = "ENABLED")
    @NotNull(message = "Filed supplier status cannot be empty or null.")
    private String supplierStatus;

    @Schema(example = "Smart Phones")
    @NotNull(message = "Filed products supplier cannot be empty or null.")
    private String productsSupplied;

    @Schema(example = "Supplier of products electronics.")
    private String supplierDescription;
}
