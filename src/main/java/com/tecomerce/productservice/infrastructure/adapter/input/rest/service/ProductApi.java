package com.tecomerce.productservice.infrastructure.adapter.input.rest.service;

import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.MessageResponse;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.ProductDTO;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public interface ProductApi {

    static final String MEDIA_TYPE = "application/json";
    @GetMapping
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = ProductDTO.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    default ResponseEntity<List<ProductDTO>> getAll() {

        return new ResponseEntity<>(List.of(
                ProductDTO.builder()
                        .id(UUID.randomUUID())
                        .productName("Lapiz")
                        .productDescription("Lapiz de grafito para escribir en cuaderno tradicional")
                        .productStock(2000)
                        .productAvailability(2000)
                        .productCreationDate(ZonedDateTime.now())
                        .productUpdateDate(ZonedDateTime.now().plusHours(2))
                        .productWeight(0.10)
                        .build()
        ),HttpStatus.OK);
    }
}
