package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/retry")
    public String retry() {
        String response = helloService.backendARetry();
        return response;
    }

    @RateLimiter(name = "internal")
    @GetMapping("/internal_ratelimit")
    public String rateLimit() {
        String response = "sheeeeesh";
        return response;
    }
}