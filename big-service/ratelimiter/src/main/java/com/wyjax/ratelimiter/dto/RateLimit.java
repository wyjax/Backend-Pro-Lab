package com.wyjax.ratelimiter.dto;

import lombok.Getter;

@Getter
public class RateLimit {
    private int burstCapacity;
    private int replenishRate;
    private int requestedToken;
}
