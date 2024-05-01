package com.tecomerce.productservice.domain.model;

import jakarta.persistence.PrePersist;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
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
    private ZonedDateTime categoryCreationDate;
    private ZonedDateTime categoryUpdateDate;
    private List<String> categoryUrlImages;
    private String categoryStatus;
    private List<String> categoryLabels;

    @PrePersist
    private void onCreated() {
        this.categoryCreationDate = ZonedDateTime.now(ZoneId.of("UTC"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id)
                && Objects.equals(categoryName, category.categoryName)
                && Objects.equals(categoryDescription, category.categoryDescription)
                && Objects.equals(categoryParent, category.categoryParent)
                && Objects.equals(categoryCreationDate, category.categoryCreationDate)
                && Objects.equals(categoryUpdateDate, category.categoryUpdateDate)
                && Objects.equals(categoryUrlImages, category.categoryUrlImages)
                && Objects.equals(categoryStatus, category.categoryStatus)
                && Objects.equals(categoryLabels, category.categoryLabels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, categoryName,
                categoryDescription, categoryParent,
                categoryCreationDate, categoryUpdateDate,
                categoryUrlImages, categoryStatus, categoryLabels);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", categoryParent='" + categoryParent + '\'' +
                ", categoryCreation=" + categoryCreationDate +
                ", categoryUpdate=" + categoryUpdateDate +
                ", categoryUrlImages=" + categoryUrlImages +
                ", categoryStatus='" + categoryStatus + '\'' +
                ", categoryLabels=" + categoryLabels +
                '}';
    }
}
