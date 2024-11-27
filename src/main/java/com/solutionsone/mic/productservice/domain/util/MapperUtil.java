package com.solutionsone.mic.productservice.domain.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solutionsone.mic.productservice.domain.exception.ErrorMappingException;
import org.springframework.stereotype.Component;

import static com.solutionsone.mic.productservice.domain.util.Message.ERROR_MAPPING;

@Component
public class MapperUtil {

    private final ObjectMapper objectMapper;

    public MapperUtil(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Object mappingEntity(String filterProperties, Class<?> clazz) {
        try {
            return objectMapper.readValue(filterProperties, clazz);
        } catch (JsonProcessingException e) {
            throw new ErrorMappingException(ERROR_MAPPING.getCode(), ERROR_MAPPING.getValue());
        }
    }
}
