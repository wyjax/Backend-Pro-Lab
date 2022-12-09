package com.wyjax.springgateway.gateway.config;

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.nio.charset.StandardCharsets.UTF_8;

public class GlobalExceptionHandler implements ErrorWebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        String errorMessage = ex.getMessage();
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().setContentLength(-1);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        response.setStatusCode(HttpStatus.BAD_REQUEST);

        DataBuffer dataBuffer = exchange.getResponse().bufferFactory().wrap(errorMessage.getBytes(UTF_8));
        return exchange.getResponse().writeWith(Flux.just(dataBuffer));
    }
}
