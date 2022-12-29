package com.wyjax.springgateway.route.repository;

import com.wyjax.springgateway.route.domain.ApiRoute;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ApiRouteRepository extends ReactiveCrudRepository<ApiRoute, Long> {
}
