package com.tecomerce.productservice.domain.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;


@Getter
@Setter
@Builder
public class ErrorResponse {

    private String code;
    private String message;
    private List<String> details;
    private ZonedDateTime timeStamp;
}
