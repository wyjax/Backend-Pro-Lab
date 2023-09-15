package com.wyjax.springgateway.route.controller;

import com.wyjax.springgateway.route.domain.ApiLimiter;
import com.wyjax.springgateway.route.model.ApiLimiterModel;
import com.wyjax.springgateway.route.service.ApiLimiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ApiLimiterController {

    private final ApiLimiterService apiLimiterService;

    @GetMapping("/api/limiter")
    public Flux<ApiLimiter> getApiLimiters() {
        return apiLimiterService.getApiLimiters();
    }

    @PostMapping("/api/limiter")
    public Mono<ApiLimiter> addApiLimiter(ApiLimiterModel apiLimiterModel) {
        return apiLimiterService.createApiLimiter(apiLimiterModel);
    }
}
