package com.wyjax.springreactiveredis.controller;

import com.wyjax.springreactiveredis.dto.CacheModel;
import com.wyjax.springreactiveredis.dto.request.PersonModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class RedisController {
    private final ReactiveRedisTemplate<String, Object> template;

    @GetMapping("/api/cache")
    public Mono<Object> getCache(@RequestParam(value = "key") String key) {
        return template.opsForValue().get(key);
    }

    @PostMapping("/api/cache")
    public Mono<Boolean> saveCache(@RequestBody CacheModel model) {
        return template.opsForValue().set(model.getKey(), model.getValue());
    }

    @GetMapping("/api/person")
    public Mono<Object> getPerson(@RequestParam(value = "key") String key) {
        return template.opsForValue().get(key);
    }

    @PostMapping("/api/person")
    public Mono<Boolean> addPerson(@RequestBody PersonModel model) {
        return template.opsForValue().set(model.getUuid(), model);
    }
}
