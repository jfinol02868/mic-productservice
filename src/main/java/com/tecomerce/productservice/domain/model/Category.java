package com.tecomerce.productservice.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private String id;
    private String categoryName;
    private String categoryDescription;
    private String categoryParent;
    private LocalDateTime categoryCreation;
    private LocalDateTime categoryUpdate;
    private List<String> categoryUrlImages;
    private String categoryStatus;
    private List<String> categoryLabels;

    public Category(Category category) {
        this.id= category.id;
        this.categoryName= category.categoryName;
        this.categoryDescription= category.categoryDescription;
        this.categoryParent= category.categoryParent;
        this.categoryCreation= category.categoryCreation;
        this.categoryUpdate= category.categoryUpdate;
        this.categoryUrlImages= category.categoryUrlImages;
        this.categoryStatus= category.categoryStatus;
        this.categoryLabels= category.categoryLabels;
    }

    public static Category newInstance(Category category) {
        return new Category(category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(categoryName, category.categoryName) && Objects.equals(categoryDescription, category.categoryDescription) && Objects.equals(categoryParent, category.categoryParent) && Objects.equals(categoryCreation, category.categoryCreation) && Objects.equals(categoryUpdate, category.categoryUpdate) && Objects.equals(categoryUrlImages, category.categoryUrlImages) && Objects.equals(categoryStatus, category.categoryStatus) && Objects.equals(categoryLabels, category.categoryLabels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, categoryDescription, categoryParent, categoryCreation, categoryUpdate, categoryUrlImages, categoryStatus, categoryLabels);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", categoryParent='" + categoryParent + '\'' +
                ", categoryCreation=" + categoryCreation +
                ", categoryUpdate=" + categoryUpdate +
                ", categoryUrlImages=" + categoryUrlImages +
                ", categoryStatus='" + categoryStatus + '\'' +
                ", categoryLabels=" + categoryLabels +
                '}';
    }
}
