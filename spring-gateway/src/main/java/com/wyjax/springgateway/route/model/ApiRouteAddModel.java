package com.wyjax.springgateway.route.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiRouteAddModel {
    private String uri;
    private String path;
    private String method;
    private String predicate;
}
