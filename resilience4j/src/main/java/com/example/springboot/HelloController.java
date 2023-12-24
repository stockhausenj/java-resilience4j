package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.client.ResourceAccessException;

import org.springframework.http.ResponseEntity;

import io.github.resilience4j.retry.annotation.Retry;


@RestController
public class HelloController {

	@Autowired
    private RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@GetMapping("/")
	@Retry(name = "backenda")
	public String index() {
		try {
			ResponseEntity<String> quote = restTemplate.getForEntity(
				"http://localhost:8080", String.class);
			log.info(quote.toString());
			return quote.toString();

		} catch (ResourceAccessException ex) {
			throw ex;
		}
	}

}