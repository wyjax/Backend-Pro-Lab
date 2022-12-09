package com.wyjax.springgateway.gateway.config;

import com.wyjax.springgateway.common.component.CommonObjectMapper;
import com.wyjax.springgateway.gateway.exception.GatewayException;
import com.wyjax.springgateway.gateway.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class GlobalExceptionHandler implements ErrorWebExceptionHandler {
    private final CommonObjectMapper objectMapper;

    public GlobalExceptionHandler() {
        this.objectMapper = new CommonObjectMapper();
    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        log.error(ex.getMessage());
        ServerHttpResponse response = exchange.getResponse();
        HttpStatus status = getStatus(ex);
        ErrorResponse errorResponse = makeErrorResponse(status, ex.getMessage());

        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        response.setStatusCode(status);

        byte[] bytes = objectMapper.writeAsBytes(errorResponse);
        DataBuffer dataBuffer = exchange.getResponse().bufferFactory().wrap(bytes);
        return exchange.getResponse().writeWith(Flux.just(dataBuffer));
    }

    private HttpStatus getStatus(Throwable ex) {
        if (ex instanceof GatewayException) {
            return ((GatewayException) ex).getStatus();
        } else if (ex instanceof ResponseStatusException) {
            return ((ResponseStatusException) ex).getStatus();
        }
        return HttpStatus.BAD_REQUEST;
    }

    private ErrorResponse makeErrorResponse(HttpStatus status, String message) {
        return ErrorResponse.builder()
                .message(message)
                .status(status.value())
                .build();
    }
}
