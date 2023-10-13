package com.microservices.accounts.dto;

import org.springframework.http.HttpStatus;

import lombok.*;

@Data @AllArgsConstructor
public class ErrorDto {

    private String apiPath;

    private HttpStatus errorCode;

    private String errorMessage;

    private String errorTime;
}
