package com.wyjax.springgateway.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class UsernameKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        String username = exchange.getRequest().getHeaders().getFirst("X-USERNAME");
        return Mono.just(username);
    }
}
