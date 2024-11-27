package com.solutionsone.mic.productservice.api.controller;

import com.solutionsone.mic.productservice.api.service.dto.BrandDto;
import com.solutionsone.mic.productservice.api.service.mapper.BrandDtoMapper;
import com.solutionsone.mic.productservice.application.usecase.brand.BrandUserCase;
import com.solutionsone.mic.productservice.domain.entity.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class BrandControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BrandUserCase useCase;
//
//    @MockBean
//    private BrandDtoMapper mapper;
//
//    private BrandDto brandDto;
//
//    @BeforeEach
//    void setUp() {
//        brandDto = new BrandDto();
//        brandDto.setName("Test Brand");
//        brandDto.setIsActive(true);
//    }
//
//    @Test
//    void testCreateBrand() throws Exception {
//        when(mapper.toModel(any(BrandDto.class))).thenReturn(new Brand());
//        when(useCase.create(any(Brand.class))).thenReturn(new Brand());
//        when(mapper.toDto(any(Brand.class))).thenReturn(brandDto);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/brands")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"name\": \"Test Brand\", \"isActive\": true}"))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name", is("Test Brand")))
//                .andExpect(jsonPath("$.isActive", is(true)));
//    }
}
