package com.solutionsone.mic.productservice.domain.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solutionsone.mic.productservice.domain.exception.ErrorMappingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class MapperUtilTest {

    @InjectMocks
    private MapperUtil mapperUtil;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMappingEntity_Success() throws JsonProcessingException {
        String json = "{\"key\":\"value\"}";
        TestClass expectedObject = new TestClass("value");

        when(objectMapper.readValue(json, TestClass.class)).thenReturn(expectedObject);

        Object result = mapperUtil.mappingEntity(json, TestClass.class);

        assertEquals(expectedObject, result);
    }

    @Test
    void testMappingEntity_ThrowsErrorMappingException() throws JsonProcessingException {
        String json = "{\"key\":\"value\"}";

        when(objectMapper.readValue(json, TestClass.class)).thenThrow(new JsonProcessingException("error") {});

        assertThrows(ErrorMappingException.class, () -> mapperUtil.mappingEntity(json, TestClass.class));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class TestClass {

        private String key;
    }
}
