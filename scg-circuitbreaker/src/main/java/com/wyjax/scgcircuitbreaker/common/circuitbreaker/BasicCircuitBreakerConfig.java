package com.wyjax.scgcircuitbreaker.common.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicCircuitBreakerConfig {

    @Bean
    public ReactiveResilience4JCircuitBreakerFactory resilience4JCircuitBreakerFactory(
        CircuitBreakerRegistry registry, TimeLimiterRegistry limiterRegistry) {
        return new ReactiveResilience4JCircuitBreakerFactory(registry, limiterRegistry);
    }

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCircuitBreaker(
        CircuitBreakerRegistry registry) {
        // registry에는 yml에서 정의헀었던 circuit breaker의 데이터가 넘어오게 된다. 이거를 넘기면? 끝난다.
        // 아래의 주석은 어떻게 사용할지에 대해서 고민했던 흔적
        return factory -> factory.configureCircuitBreakerRegistry(registry);
    }

//    @SuppressWarnings("DataFlowIssue")
//    @Bean(name = "defaultCircuitBreaker")
//    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCircuitBreaker2(
//        CommonCircuitBreakerConfigurationProperties properties) {
//        InstanceProperties instanceProperties = properties.getConfigs().get("default");
//
//        CircuitBreakerConfig defaultConfig = CircuitBreakerConfig.custom()
//            .slidingWindowType(Objects.requireNonNull(instanceProperties.getSlidingWindowType()))
//            .slidingWindowSize(instanceProperties.getSlidingWindowSize())
//            .failureRateThreshold(instanceProperties.getFailureRateThreshold())
//            .slowCallDurationThreshold(instanceProperties.getSlowCallDurationThreshold())
//            .slowCallRateThreshold(instanceProperties.getSlowCallRateThreshold())
//            .ignoreExceptions(IGNORE_EXCEPTIONS)
//            .build();
//        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//            .circuitBreakerConfig(defaultConfig)
//            .build());
//    }

//    @Bean(name = "defaultCircuitBreaker")
//    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCircuitBreaker() {
//        CircuitBreakerConfig defaultConfig = CircuitBreakerConfig.custom()
//            .slidingWindow(10, 20, SlidingWindowType.TIME_BASED)
//            .failureRateThreshold(50)
//            .slowCallDurationThreshold(Duration.ofSeconds(5))
//            .slowCallRateThreshold(90)
//            .ignoreExceptions(IGNORE_EXCEPTIONS)
//            .build();
//        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//            .circuitBreakerConfig(defaultConfig)
//            .build());
//    }

}
