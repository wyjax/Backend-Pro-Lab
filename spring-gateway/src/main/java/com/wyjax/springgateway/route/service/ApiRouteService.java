package com.wyjax.springgateway.route.service;

import com.wyjax.springgateway.route.domain.ApiRoute;
import com.wyjax.springgateway.route.model.ApiRouteAddModel;
import com.wyjax.springgateway.route.repository.ApiRouteRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ApiRouteService {

    private final ApiRouteRepository apiRouteRepository;

    @Transactional(readOnly = true)
    public Flux<ApiRoute> getRoutes() {
        List<ApiRoute> apiRoutes = apiRouteRepository.findAll();
        return Flux.fromIterable(apiRoutes);
    }

    @Transactional
    public Mono<ApiRoute> addRoute(ApiRouteAddModel model) {
        ApiRoute apiRoute = ApiRoute.builder()
            .uri(model.getUri())
            .path(model.getPath())
            .method(model.getMethod())
            .predicate(model.getPredicate())
            .build();
        return Mono.just(apiRouteRepository.save(apiRoute));
    }
}
