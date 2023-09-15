package com.wyjax.springgateway.route.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiLimiterModel {

    private String path;
    private String method;

    private int threshold;
    private int ttl;

    private boolean active;
}
