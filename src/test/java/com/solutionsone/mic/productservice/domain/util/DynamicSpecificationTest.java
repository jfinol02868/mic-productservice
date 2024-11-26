package com.solutionsone.mic.productservice.domain.util;

import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.BrandEntity;
import com.solutionsone.mic.productservice.infrastructure.bd.util.DynamicSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DynamicSpecificationTest {


        @Test
        void testByFields() {
            // Create a filter object with some fields set
            class FilterObject {
                private String name = "TestBrand";
                private Integer id = 1;
            }

            FilterObject filterObject = new FilterObject();

            // Generate the specification
            Specification<BrandEntity> specification = DynamicSpecification.byFields(filterObject);

            // Assert that the specification is not null
            assertNotNull(specification);
        }
}
