package com.wyjax.springgateway.gateway.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private Integer status;
    private String message;
    private boolean error;
    private String data;
    private String result;
}
