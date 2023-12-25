package com.example.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;


@Service
public class HelloService {

    @Autowired
    public HelloService() {}

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Retry(name = "backenda")
    public String getBackendA() {
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