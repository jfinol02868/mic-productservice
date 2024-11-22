package com.solutionsone.mic.productservice.infrastructure.bd.util;

import com.solutionsone.mic.productservice.domain.exception.AccessToFieldException;
import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.BrandEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DynamicSpecification {

    private DynamicSpecification() {}

    public static Specification<BrandEntity> byFields(Object filterObject) {

        return (Root<BrandEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Field[] fields = filterObject.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(filterObject);
                    if (Objects.nonNull(value)) {
                        predicates.add(criteriaBuilder.equal(root.get(field.getName()), value));
                    }
                } catch (IllegalAccessException e) {
                    throw new AccessToFieldException("AC001", "Error al acceder al campo: ".concat(field.getName()));
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
