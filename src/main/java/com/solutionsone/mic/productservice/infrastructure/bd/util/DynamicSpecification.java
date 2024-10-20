package com.solutionsone.mic.productservice.infrastructure.bd.util;

import com.solutionsone.mic.productservice.domain.entity.Brand;
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

    public static Specification<Brand> byFields(Object filterObject) {
        return (Root<Brand> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Obtener los campos del objeto filtrado usando reflexión
            Field[] fields = filterObject.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true); // Permitir el acceso a campos privados
                try {
                    Object value = field.get(filterObject); // Obtener el valor del campo
                    if (Objects.nonNull(value)) {
                        // Crear una condición con el campo
                        predicates.add(criteriaBuilder.equal(root.get(field.getName()), value));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error al acceder al campo: " + field.getName());
                }
            }

            // Combinar los predicados en una sola consulta (si hay alguno)
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
