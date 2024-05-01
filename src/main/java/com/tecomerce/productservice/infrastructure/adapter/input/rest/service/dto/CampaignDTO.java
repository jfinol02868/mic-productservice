package com.tecomerce.productservice.infrastructure.adapter.input.rest.service.dto;

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
public class CampaignDTO implements Serializable {


	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@Schema(example = "bc36bacd-b110-4aa3-a083-fe9c5a3404b6")
	private String id;

	@Schema(example = "Verano")
	@NotNull(message = "Field cannot be empty or null.")
	private String name;

	@Schema(example = "Summer campaign")
	private String description;

	@Schema(example = "Prada")
	private String tenant;

	@Schema(example = "2024-05-01T20:35:10")
	private ZonedDateTime startDate;

	@Schema(example = "2024-06-01T20:35:10")
	private ZonedDateTime endDate;
}
