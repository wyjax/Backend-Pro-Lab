package com.wyjax.springgateway.gateway.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GatewayException extends IllegalArgumentException {
    private final HttpStatus status;

    public GatewayException(HttpStatus status) {
        this.status = status;
    }

    public GatewayException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
