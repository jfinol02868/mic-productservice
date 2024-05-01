package com.tecomerce.productservice.infrastructure.adapter.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name =  "campaigns")
public class CampaignEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "tenant")
    private String tenant;
    @Column(name = "start_date")
    private ZonedDateTime startDate;
    @Column(name = "end_date")
    private ZonedDateTime endDate;
}
