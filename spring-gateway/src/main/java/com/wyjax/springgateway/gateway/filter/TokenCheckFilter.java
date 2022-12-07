package com.wyjax.springgateway.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class TokenCheckFilter extends AbstractGatewayFilterFactory<TokenCheckFilter.Config> {
    private static final String TOKEN_PREFIX = "Bearer ";

    public TokenCheckFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
            String token = httpHeaders.getFirst(AUTHORIZATION);

            if (token == null) {
                ServerHttpResponse response = exchange.getResponse();
                return onError(response, "no token", HttpStatus.BAD_REQUEST);
            }
            if (!token.startsWith(TOKEN_PREFIX)) {
                ServerHttpResponse response = exchange.getResponse();
                return onError(response, "no token", HttpStatus.UNAUTHORIZED);
            }
            return chain.filter(exchange);
        };
    }

    private Mono<Void> onError(ServerHttpResponse response, String message, HttpStatus status) {
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        response.setStatusCode(status);
        DataBuffer buffer = response.bufferFactory().wrap(message.getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Mono.just(buffer));
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
