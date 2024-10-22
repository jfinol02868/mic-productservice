package com.solutionsone.mic.productservice.api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandDto {


    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "The brand id", example = "GLOBAL::PRODUCTSERVICE::BRAND::B615044B-26C2-44C1-9B88-E27252E7685A::DES")
    private String id;

    @NotNull
    @Schema(description = "The brand name", example = "WOULD")
    private String name;

    @Schema(description = "The brand description", example = "WOULD SPORTSWEAR")
    private String description;

    @Schema(description = "The brand code", example = "http://www.would.com/images/logo.png")
    private String logoUrl;

    @Schema(description = "The brand website", example = "http://www.would.com")
    private String websiteUrl;

    @NotNull
    @Schema(description = "The brand is active", example = "true")
    private Boolean isActive;
}
