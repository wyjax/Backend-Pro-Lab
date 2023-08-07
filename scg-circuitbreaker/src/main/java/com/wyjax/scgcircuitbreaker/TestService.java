package com.wyjax.scgcircuitbreaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @CircuitBreaker(name = "test")
    public void test(long time) {
        System.out.println("inininininininin");
        if (time == 0) {
            throw new NullPointerException("null이당");
        }
        if (time % 2 == 1) {
            return;
        }
        throw new NullPointerException("null이당");
    }
}
