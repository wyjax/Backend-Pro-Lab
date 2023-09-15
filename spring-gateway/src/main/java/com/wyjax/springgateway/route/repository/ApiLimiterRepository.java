package com.wyjax.springgateway.route.repository;

import com.wyjax.springgateway.route.domain.ApiLimiter;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Mono;

public interface ApiLimiterRepository extends JpaRepository<ApiLimiter, Long> {

    Optional<ApiLimiter> findByPathAndMethodAndActiveIsTrue(String path, String method);
}
