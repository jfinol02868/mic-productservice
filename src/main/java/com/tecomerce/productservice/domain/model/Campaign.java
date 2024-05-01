package com.tecomerce.productservice.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Campaign implements Serializable {

	private String id;
	private String name;
	private String description;
	private String tenant;
	private ZonedDateTime startDate;
	private ZonedDateTime endDate;
}
