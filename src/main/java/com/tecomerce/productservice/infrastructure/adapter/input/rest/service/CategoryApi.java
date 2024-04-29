package com.tecomerce.productservice.infrastructure.adapter.input.rest.service;

import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.CategoryDTO;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.MessageResponse;
import com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategoryApi {

    static final String MEDIA_TYPE = "application/json";

    @PostMapping
    @Operation( operationId = "creation-category", description = "Creation of category.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = CategoryDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    default ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/{id}")
    @Operation( operationId = "get-category-by-id", description = "Get category by id.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = CategoryDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    default ResponseEntity<CategoryDTO> findById(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    @GetMapping
    @Operation( operationId = "get-all-categories", description = "Get all categories.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = CategoryDTO.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    default ResponseEntity<List<CategoryDTO>> findAll() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{id}")
    @Operation( operationId = "update-category", description = "Update category.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = CategoryDTO.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, array = @ArraySchema( schema = @Schema(implementation = MessageResponse.class))))
    default ResponseEntity<CategoryDTO> update(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{id}")
    @Operation( operationId = "delete-category", description = "Delete category by id.")
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
