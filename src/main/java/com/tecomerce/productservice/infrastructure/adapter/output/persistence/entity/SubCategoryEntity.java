package com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name =  "subcategories")
public class SubCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String categoryName;
    private String categoryDescription;
    private String categoryParent;
    private ZonedDateTime subCategoryCreationDate;
    private ZonedDateTime subCategoryUpdateDate;
    private List<String> categoryUrlImages;
    private String categoryStatus;
    private List<String> categoryLabels;

    @PrePersist
    private void onCreated() {
        this.subCategoryCreationDate = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
