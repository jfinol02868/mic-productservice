package com.tecomerce.productservice.infrastructure.adapter.input.rest.service;

import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.MessageResponse;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.ProductDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductApi {

    static final String MEDIA_TYPE = "application/json";

    @PostMapping
    @Operation( operationId = "creation-product", description = "Creation of products.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = ProductDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    default ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/{id}")
    @Operation( operationId = "get-product-by-id", description = "Get product by id.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = ProductDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    default ResponseEntity<ProductDTO> findById(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    @GetMapping
    @Operation( operationId = "get-all-products", description = "Get all products.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = ProductDTO.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    default ResponseEntity<List<ProductDTO>> findAll() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{id}")
    @Operation( operationId = "update-product", description = "Update product.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = ProductDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    default ResponseEntity<ProductDTO> update(@Valid @RequestBody ProductDTO productDTO, @PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{id}")
    @Operation( operationId = "delete-product", description = "Delete product by id.")
    @ApiResponse(responseCode = "204", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = Void.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    default ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


}
