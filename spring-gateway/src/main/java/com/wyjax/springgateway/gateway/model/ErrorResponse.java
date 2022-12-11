package com.wyjax.springgateway.gateway.model;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
    private Integer status;
    private String message;
    private String data;
    private String result;
}
