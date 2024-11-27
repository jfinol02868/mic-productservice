package com.solutionsone.mic.productservice.api.service.dto;

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
    @Schema(description = "The brand id", example = "1")
    private String id;

    @NotNull
    @Schema(description = "The brand name", example = "WOULD")
    private String name;

    @Schema(description = "The brand description", example = "WOULD SPORTSWEAR")
    private String description;

    @Schema(description = "The brand logo URL", example = "http://www.would.com/images/logo.png")
    private String logoUrl;

    @Schema(description = "The brand website URL", example = "http://www.would.com")
    private String websiteUrl;

    @NotNull
    @Schema(description = "The brand is active", example = "true")
    private Boolean isActive;

    @Schema(description = "The country where the brand originates", example = "USA")
    private String countryOfOrigin;

    @Schema(description = "The registration date of the brand", example = "2024-11-27T14:30:00Z")
    private ZonedDateTime registrationDate;

    @Schema(description = "Indicates if the brand is exclusive to the retailer", example = "true")
    private Boolean isExclusive;

    @Schema(description = "The brand's contact information", example = "support@would.com")
    private String contactInfo;

    @Schema(description = "The brand's average rating", example = "4.5")
    private Double averageRating;
}
