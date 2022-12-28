package com.wyjax.springgateway.route.repository;

import com.wyjax.springgateway.route.domain.ApiLimiter;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ApiLimiterRepository extends ReactiveCrudRepository<ApiLimiter, Long> {

    Mono<ApiLimiter> findByPathAndMethodAndActiveIsTrue(String path, String method);
}
