package com.example.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	private final HelloService helloService;

	private static final Logger log = LoggerFactory.getLogger(Application.class);

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