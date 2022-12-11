package com.wyjax.springgateway.gateway.filter;

import com.wyjax.springgateway.gateway.exception.GatewayException;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

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
                throw new GatewayException(HttpStatus.BAD_REQUEST, "토큰이 존재하지 않습니다.");
            }
            if (!token.startsWith(TOKEN_PREFIX)) {
                throw new GatewayException(HttpStatus.UNAUTHORIZED, "토큰이 인가되지 않습니다.");
            }
            return chain.filter(exchange);
        };
    }

    public static class Config {
        //Put the configuration properties for your filter here
    }
}
