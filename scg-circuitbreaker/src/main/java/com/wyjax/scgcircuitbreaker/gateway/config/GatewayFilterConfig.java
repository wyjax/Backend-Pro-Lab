package com.wyjax.scgcircuitbreaker.gateway.config;

import com.wyjax.scgcircuitbreaker.gateway.exception.GlobalExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayFilterConfig {

    @Bean
    public ErrorWebExceptionHandler webExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
