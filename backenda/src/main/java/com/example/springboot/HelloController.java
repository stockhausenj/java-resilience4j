package com.example.springboot;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	private boolean shouldThrowException() {
        Random random = new Random();
        return random.nextDouble() < 0.5; // 50% probability
    }
	
	@GetMapping("/retry")
	public ResponseEntity retry() {
		try {
            // Simulate an exception 50% of the time
            if (shouldThrowException()) {
                // Throw an exception (e.g., division by zero)
                int result = 10 / 0; // This will throw an ArithmeticException
            }

            // If no exception occurs, return a success response
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            // In case of an exception, return a 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
	}
}
