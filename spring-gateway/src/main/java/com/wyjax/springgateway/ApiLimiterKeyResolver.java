package com.wyjax.springgateway;

import com.wyjax.springgateway.route.service.ApiLimiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ApiLimiterKeyResolver implements KeyResolver {
    private final ApiLimiterService apiLimiterService;
    private final ObjectHelper objectHelper;

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        String path = exchange.getRequest().getPath().value();
        String method = exchange.getRequest().getMethodValue();
        return apiLimiterService.getApiLimiter(path, method)
                .doOnNext(apiLimiter -> apiLimiter.setPath(path))
                .map(objectHelper::toStringBase64);
    }
}
