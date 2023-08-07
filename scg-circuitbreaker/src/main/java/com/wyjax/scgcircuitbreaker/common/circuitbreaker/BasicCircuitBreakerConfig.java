package com.wyjax.scgcircuitbreaker.common.circuitbreaker;

import com.wyjax.scgcircuitbreaker.exception.AuthenticationException;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import java.io.IOException;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.HttpServerErrorException;

@Configuration
public class BasicCircuitBreakerConfig {

    public static final Class[] IGNORE_EXCEPTIONS = new Class[]{
        AuthenticationException.class, IOException.class, HttpServerErrorException.class,
        IllegalArgumentException.class, IllegalStateException.class};

    @Bean
    public ReactiveResilience4JCircuitBreakerFactory resilience4JCircuitBreakerFactory(
        CircuitBreakerRegistry registry, TimeLimiterRegistry limiterRegistry) {
        return new ReactiveResilience4JCircuitBreakerFactory(registry, limiterRegistry);
    }

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCircuitBreaker(
        CircuitBreakerRegistry registry) {
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
