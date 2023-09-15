package com.wyjax.springgateway.route.service;

import com.wyjax.springgateway.route.domain.ApiLimiter;
import com.wyjax.springgateway.route.model.ApiLimiterModel;
import com.wyjax.springgateway.route.repository.ApiLimiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ApiLimiterService {

    private final ApiLimiterRepository apiLimiterRepository;

    public Flux<ApiLimiter> getApiLimiters() {
        return Flux.fromIterable(apiLimiterRepository.findAll());
    }

    @Transactional
    public Mono<ApiLimiter> createApiLimiter(ApiLimiterModel apiLimiterModel) {
        ApiLimiter apiLimiter = ApiLimiter.builder()
            .build();
        return Mono.just(apiLimiterRepository.save(apiLimiter));
    }

    public Mono<ApiLimiter> getApiLimiter(String path, String method) {
        ApiLimiter apiLimiter = apiLimiterRepository.findByPathAndMethodAndActiveIsTrue(path,
                method)
            .orElseThrow();
        return Mono.just(apiLimiter);
    }
}
