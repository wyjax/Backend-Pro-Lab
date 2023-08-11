package com.wyjax.scgcircuitbreaker.common.ratelimiter;

import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import java.time.Duration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRatelimiterConfig {

    @Bean("testRatelimiter")
    public RateLimiterRegistry gatewayRateLimiterRegistry() {
        RateLimiterConfig config = RateLimiterConfig.custom()
            .limitForPeriod(10)
            .limitRefreshPeriod(Duration.ofMillis(1))
            .timeoutDuration(Duration.ofMillis(25))
            .build();
        return RateLimiterRegistry.of(config);
    }
}
