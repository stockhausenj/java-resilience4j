package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


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

    @GetMapping("/ratelimit")
	public String rateLimit() {
        String response = helloService.backendARetry();
		return response;
	}
}