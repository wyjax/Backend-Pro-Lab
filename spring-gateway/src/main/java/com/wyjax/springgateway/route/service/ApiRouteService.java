package com.wyjax.springgateway.route.service;

import com.wyjax.springgateway.route.domain.ApiRoute;
import com.wyjax.springgateway.route.model.ApiRouteAddModel;
import com.wyjax.springgateway.route.repository.ApiRouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ApiRouteService {

    private final ApiRouteRepository apiRouteRepository;

    public Flux<ApiRoute> getRoutes() {
        return apiRouteRepository.findAll();
    }

    public Mono<ApiRoute> addRoute(ApiRouteAddModel model) {
        ApiRoute apiRoute = ApiRoute.builder()
            .uri(model.getUri())
            .path(model.getPath())
            .method(model.getMethod())
            .predicate(model.getPredicate())
            .build();
        return apiRouteRepository.save(apiRoute);
    }
}
