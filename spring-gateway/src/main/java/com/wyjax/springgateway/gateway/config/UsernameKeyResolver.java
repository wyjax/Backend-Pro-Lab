package com.wyjax.springgateway.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component("usernameKeyResolver")
public class UsernameKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        return Mono.just(name);
    }
}
