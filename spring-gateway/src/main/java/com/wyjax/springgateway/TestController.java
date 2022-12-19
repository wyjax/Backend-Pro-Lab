package com.wyjax.springgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/v2/good/man")
    public String good() {
        return "dwd";
    }

    @PostMapping("/api/v2/good/woman")
    public String good2() {
        return "dwd";
    }
}
