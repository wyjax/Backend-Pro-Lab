package com.wyjax.scgcircuitbreaker;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/api/good")
    public String good() {
        testService.test(0);
        return "fwfwd";
    }

    @GetMapping("/api/good2")
    public String good2() {
        testService.test(System.nanoTime());
        return "fwfwd";
    }
}
