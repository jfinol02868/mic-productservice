package com.solutionsone.mic.productservice.infrastructure.bd.postgres.repository.specification;

import com.solutionsone.mic.productservice.infrastructure.bd.postgres.entity.BrandEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BrandSpecification<T> {

    private static final String LIKE = "%";

    public static <T> Specification<T> byExample(T example) {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Obtener todos los campos de la clase
            Field[] fields = example.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);  // Permitir acceso a campos privados
                try {
                    Object value = field.get(example);  // Obtener el valor del campo
                    if (Objects.nonNull(value)) {
                        // Generar la consulta en función del tipo de campo
                        if (value instanceof String) {
                            predicates.add(criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get(field.getName())),
                                    LIKE + ((String) value).toLowerCase() + LIKE));
                        } else if (value instanceof ZonedDateTime) {
                            predicates.add(criteriaBuilder.equal(root.get(field.getName()), value));
                        } else if (value instanceof Boolean) {
                            predicates.add(criteriaBuilder.equal(root.get(field.getName()), value));
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error al acceder al campo: " + field.getName(), e);
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    /*private static final String like = "%";

    public static Specification<BrandEntity> hasId(String id) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(id) || id.isEmpty()) {
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("id")), like.concat(id.toLowerCase()).concat(like));
        };
    }

    public static Specification<BrandEntity> hasName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(name) || name.isEmpty()) {
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), like.concat(name.toLowerCase()).concat(like));
        };
    }

    public static Specification<BrandEntity> hasLogoUrl(String logoUrl) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(logoUrl) || logoUrl.isEmpty()) {
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("logoUrl")), like.concat(logoUrl.toLowerCase()).concat(like));
        };
    }

    public static Specification<BrandEntity> hasWebsiteUrl(String websiteUrl) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(websiteUrl) || websiteUrl.isEmpty()) {
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("websiteUrl")), like.concat(websiteUrl.toLowerCase()).concat(like));
        };
    }

    public static Specification<BrandEntity> hasCreatedDate(ZonedDateTime createdDate) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(createdDate)) {
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("createdDate")), like.concat(String.valueOf(createdDate)).concat(like));
        };
    }

    public static Specification<BrandEntity> hasUpdatedDate(ZonedDateTime updatedDate) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(updatedDate)) {
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("updatedDate")), like.concat(String.valueOf(updatedDate)).concat(like));
        };
    }

    public static Specification<BrandEntity> hasIsActive(Boolean isActive) {
        return (root, query, criteriaBuilder) -> {
            if (Objects.isNull(isActive)) {
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("isActive")), like.concat(String.valueOf(isActive)).concat(like));
        };
    }*/
}
