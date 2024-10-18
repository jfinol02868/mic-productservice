package com.solutionsone.mic.productservice.api.service;

import com.solutionsone.mic.productservice.api.service.dto.BrandDto;
import com.solutionsone.mic.productservice.api.service.dto.MessageResponseDTO;
import com.solutionsone.mic.productservice.api.service.dto.SortEnumDTO;
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

public interface BrandApi {

    static final String MEDIA_TYPE = "application/json";

    @PostMapping
    @Operation( operationId = "creation-color", description = "Creation of color.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = BrandDto.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<BrandDto> create(@Valid @RequestBody BrandDto entity) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/massCreation")
    @Operation( operationId = "create-all-color", description = "Create all colors.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = BrandDto.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default  ResponseEntity<List<BrandDto>> createAll(@Valid @RequestBody List<BrandDto> entities) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/{id}")
    @Operation( operationId = "update-color", description = "Update color.")
    @ApiResponse(responseCode = "201", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = BrandDto.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<BrandDto> update(@Valid @RequestBody BrandDto entity, @PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/massUpdate")
    @Operation( operationId = "update-all-colors", description = "Update all colors.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = BrandDto.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<BrandDto>> updateAll(@Valid @RequestBody List<BrandDto> entities){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/{id}")
    @Operation( operationId = "get-color-by-id", description = "Get color by id.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = BrandDto.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<BrandDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/getByIds")
    @Operation( operationId = "get-colors-by-ids", description = "Get colors by ids.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = BrandDto.class))))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE, schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<BrandDto>> findByIds(@RequestParam List<String> id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/{id}")
    @Operation( operationId = "delete-color", description = "Delete color by id.")
    @ApiResponse(responseCode = "204", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = Void.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<Void> delete(@PathVariable String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/deleteByIds")
    @Operation( operationId = "delete-all-colors", description = "Delete colors by ids.")
    @ApiResponse(responseCode = "204", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = Void.class)))
    @ApiResponse(responseCode = "400", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "404", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<Void> deleteAll(@RequestParam List<String> ids) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/paginated")
    @Operation( operationId = "get-colors-paginated", description = "Get colors paginated.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = BrandDto.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<BrandDto>> findAllPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, String sort, SortEnumDTO direction) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @GetMapping("/colorsFilter")
    @Operation( operationId = "get-colors-filter", description = "Get colors by filter.")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = MEDIA_TYPE,  array = @ArraySchema(schema = @Schema(implementation = BrandDto.class))))
    @ApiResponse(responseCode = "401", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "403", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    @ApiResponse(responseCode = "500", content = @Content(mediaType = MEDIA_TYPE,  schema = @Schema(implementation = MessageResponseDTO.class)))
    default ResponseEntity<List<BrandDto>> filters(
            @RequestParam(required = false, defaultValue = "{\"name\":\"Negro\", \"code\":\"000001\", \"hex\":\"#000000\"}") String filterProperties,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false) SortEnumDTO direction,
            @RequestParam(required = false, defaultValue = "createAt") String... sortProperties) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
