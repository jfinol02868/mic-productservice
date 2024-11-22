package com.solutionsone.mic.productservice.domain.audit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Audit {

    private String id;
    private ActionType action;
    private String user;
    private String description;
    private String component;
}
