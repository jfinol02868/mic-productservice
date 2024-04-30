package com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto;

import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampaignDTO implements Serializable {

    private String id;
	private String name;
	private String description;
	private String tenant;
	private ZonedDateTime startDate;
	private ZonedDateTime endDate;
}
