package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.specification;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BrandSpecification<T> {

    public Specification<T> byExample(T value) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            buildPredicates(value, root, criteriaBuilder, predicates, "");
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    private void buildPredicates(Object example, Root<?> root, CriteriaBuilder criteriaBuilder,
                                 List<Predicate> predicates, String parentField) {

        Field[] fields = example.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(example);

                if (Objects.nonNull(value)) {
                    if (isEmbeddableOrEntity(field.getType())) {
                        buildPredicates(value, root, criteriaBuilder, predicates, parentField + field.getName() + ".");
                    } else {
                        predicates.add(criteriaBuilder.equal(root.get(parentField + field.getName()), value));
                    }
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error al acceder al campo: " + field.getName(), e);
            }
        }
    }

    private boolean isEmbeddableOrEntity(Class<?> clazz) {
        return clazz.isAnnotationPresent(Embeddable.class) || clazz.isAnnotationPresent(Entity.class);
    }
}
