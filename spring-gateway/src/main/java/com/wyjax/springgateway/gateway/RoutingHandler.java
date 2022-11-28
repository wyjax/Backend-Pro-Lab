package com.wyjax.springgateway.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingHandler {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("r1", r -> r.host("localhost:8081")
                        .and()
                        .path("/second")
                        .uri("http://localhost:8081")
                ).build();
    }
}
