package com.wyjax.webfluxstudy;

import org.reactivestreams.Subscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/api/flatmap")
    public Mono flatmap() {
        long start = System.nanoTime();
        return createFlux()
                .flatMap(integer -> {
                    System.out.println(integer);
                    return Mono.empty();
                }).then(Mono.defer(() -> {
                    long end = System.nanoTime();
                    System.out.println(end - start);
                    return Mono.empty();
                }));
    }

    @GetMapping("/api/concatmap")
    public Mono concatmap() {
        long start = System.nanoTime();
        return createFlux()
                .concatMap(integer -> {
                    System.out.println(integer);
                    return Mono.empty();
                }).then(Mono.defer(() -> {
                    long end = System.nanoTime();
                    System.out.println(end - start);
                    return Mono.empty();
                }));
    }

    private Flux<Integer> createFlux() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        return Flux.fromIterable(list);
    }
}
