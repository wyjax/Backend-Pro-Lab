package com.wyjax.springgateway.route.service;

import com.wyjax.springgateway.route.domain.ApiLimiter;
import com.wyjax.springgateway.route.model.ApiLimiterModel;
import com.wyjax.springgateway.route.repository.ApiLimiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ApiLimiterService {
    private final ApiLimiterRepository apiLimiterRepository;

    public Flux<ApiLimiter> getApiLimiters() {
        return apiLimiterRepository.findAll();
    }

    public Mono<ApiLimiter> createApiLimiter(ApiLimiterModel apiLimiterModel) {
        ApiLimiter apiLimiter = ApiLimiter.builder()
                .build();
        return apiLimiterRepository.save(apiLimiter);
    }

    public Mono<ApiLimiter> getApiLimiter(String path, String method) {
        return apiLimiterRepository.findByPathAndMethodAndActiveIsTrue(path, method);
    }
}
