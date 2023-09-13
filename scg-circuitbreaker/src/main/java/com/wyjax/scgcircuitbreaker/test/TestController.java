package com.wyjax.scgcircuitbreaker.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @GetMapping("/api/good")
    public Mono<String> test() {
        return Mono.just("goodman");
    }
}
