package com.wyjax.springreactiveredis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class RedisController {
    private static final String CACHE_NAME = "black";
    private final RedisCacheManager redisCacheManager;

    @GetMapping("/api/cache")
    public Mono<String> getCache(@RequestParam String key) {
        Cache.ValueWrapper valueWrapper = redisCacheManager.getCache(CACHE_NAME).get(key);
        return Mono.just(valueWrapper.get().toString());
    }

    @PostMapping("/api/cache")
    public Mono<String> saveCache(@RequestBody String cache) {
        redisCacheManager.getCache(CACHE_NAME).put(cache, cache);
        return Mono.just("success");
    }
}
