package com.tecomerce.productservice.infrastructure.rest.api.service;

import com.tecomerce.productservice.infrastructure.rest.api.service.dto.ProductDTO;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ProductApi {

    static final String MEDIA_TYPE = "application/json";
    @GetMapping
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = ProductDTO.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = ProductDTO.class))))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = ProductDTO.class))))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = ProductDTO.class))))
    default ResponseEntity<List<ProductDTO>> getAll() {
       return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
