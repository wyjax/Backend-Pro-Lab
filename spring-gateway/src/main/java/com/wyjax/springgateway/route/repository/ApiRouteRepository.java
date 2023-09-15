package com.wyjax.springgateway.route.repository;

import com.wyjax.springgateway.route.domain.ApiRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ApiRouteRepository extends JpaRepository<ApiRoute, Long> {
}
