package com.wyjax.scgcircuitbreaker.gateway.exception;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class GlobalExceptionHandler implements ErrorWebExceptionHandler {

    @Override
    @CircuitBreaker(name = "gateway")
    public Mono<Void> handle(ServerWebExchange exchange, Throwable e) {
        System.out.println("goodman");
        log.error("GlobalException error", e);
        ServerHttpResponse response = exchange.getResponse();
        HttpStatus status = getStatus(e);

        if (status.isError()) {
            throw new RuntimeException();
        }
        return response.setComplete();
    }

    private HttpStatus getStatus(Throwable ex) {
        return HttpStatus.BAD_REQUEST;
    }

}
