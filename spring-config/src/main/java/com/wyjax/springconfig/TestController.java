package com.wyjax.springconfig;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController  {

    @GetMapping("/api/test")
    public String good(HttpServletRequest request) {
        return "test";
    }
}
