package com.wyjax.webfluxstudy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SimpleTest {

    @Test
    void flatMap() {
        createFlux()
                .doOnNext(integer -> System.out.println("next: " + integer))
                .doOnComplete(() -> System.out.println("complete!"));
    }

    private void good(Integer integer) {
        System.out.println(integer);
    }

    private Flux<Integer> createFlux() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        return Flux.fromIterable(list);
    }
}
