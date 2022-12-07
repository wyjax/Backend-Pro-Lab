package com.wyjax.springgateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class TokenCheckFilter extends AbstractGatewayFilterFactory<TokenCheckFilter.Config> {
    private static final String BEARER_TOKEN = "Bearer";

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
            String token = httpHeaders.getFirst(HttpHeaders.AUTHORIZATION);

            if (token == null) {
                throw new IllegalStateException("token이 존재하지 않습니다.");
            }
            if (!token.startsWith(BEARER_TOKEN)) {
                throw new IllegalStateException("Bearer 형식으로 보내주세요.");
            }
            return chain.filter(exchange);
        };
    }

    public static class Config {

    }
}
