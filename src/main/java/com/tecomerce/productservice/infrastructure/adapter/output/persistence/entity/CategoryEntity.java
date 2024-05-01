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
@Entity(name =  "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
}
