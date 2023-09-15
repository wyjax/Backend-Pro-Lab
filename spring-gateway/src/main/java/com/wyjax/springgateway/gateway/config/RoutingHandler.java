package com.wyjax.springgateway.gateway.config;

import com.wyjax.springgateway.route.component.ApiRouteLocator;
import com.wyjax.springgateway.route.service.ApiRouteService;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingHandler {

    // yml에 정의한 내용이랑 bean으로 정의한 내용은 병합되어 설정된다.
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("r1", r -> r.host("localhost:8081")
                .and()
                .path("/second")
                .uri("http://localhost:8081")
            ).build();
    }

    @Bean
    public RouteLocator routeLocator(ApiRouteService apiRouteService,
        RouteLocatorBuilder routeLocatorBuilder) {
        return new ApiRouteLocator(apiRouteService, routeLocatorBuilder);
    }

    @Bean
    public ErrorWebExceptionHandler webExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
