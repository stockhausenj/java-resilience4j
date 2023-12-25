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

	@GetMapping("/")
	public String index() {
        String response = helloService.getBackendA();
		return response;
	}
}