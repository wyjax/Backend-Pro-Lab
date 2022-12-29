package com.wyjax.springgateway.route.controller;

import com.wyjax.springgateway.route.domain.ApiRoute;
import com.wyjax.springgateway.route.model.ApiRouteAddModel;
import com.wyjax.springgateway.route.service.ApiRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiRouteController {
    private final ApiRouteService apiRouteService;
    private final List<RouteLocator> routeLocators;

    @GetMapping("/api/route")
    public String good() {
        return "dwd";
    }

    @PostMapping("/api/route")
    public Mono<ApiRoute> addRoute(@RequestBody ApiRouteAddModel model) {
        return apiRouteService.addRoute(model);
    }
}
