package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.impl;

import com.solutionsone.mic.productservice.domain.entity.Brand;
import com.solutionsone.mic.productservice.domain.repository.BrandRepository;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.mapper.BrandEntityMapper;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.BrandRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BrandRepositoryImplTest {

    @Mock
    private BrandRepository brandRepository;

    private BrandRepositoryAdapter brandRepositoryAdapter;

    @Mock
    private BrandEntityMapper brandEntityMapper;

    private List<Brand> brands = new ArrayList<>();


    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
        brands = List.of(
                Brand.builder()
                        .id("PRODUCTSERVICE::BRAND::B615047B-26C2-44C1-9B88-E27252E7685A::DES")
                        .name("Calvin Klein")
                        .description("Calvin Klein Fashion")
                        .websiteUrl("http://www.calvinklein.com")
                        .logoUrl("http://www.calvinklein.com/logo.png")
                        .isActive(true)
                        .build(),
                Brand.builder()
                        .id("PRODUCTSERVICE::BRAND::B615046B-26C2-44C1-9B88-E27252E7685A::DES")
                        .name("Guess")
                        .description("Guess Fashion Apparel")
                        .websiteUrl("http://www.guess.com")
                        .logoUrl("http://www.guess.com/logo.png")
                        .isActive(true)
                        .build()
        );
    }

    @Test
    @DisplayName("Filtrar marcas por atributos, paginar y ordenar")
    void filtersTest() {

        //Arrange

        //Act
        when(brandRepository.filters(any(Brand.class), eq(0), eq(10), eq("ASC"), eq("name"))).thenReturn(brands);

        //Assert
        List<Brand> result = brandRepository.filters(Brand.builder().build(), 0, 10, "ASC", "name");
        verify(brandRepository, times(1)).filters(Brand.builder().build(), 0, 10, "ASC", "name");
    }
}
