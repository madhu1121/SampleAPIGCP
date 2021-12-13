package com.example.SampleAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
public class SampleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApiApplication.class, args);

	}

	@GetMapping("/welcome")
	public String hello() {
		return "Hello madhu";
	}

	@GetMapping("/welcome/{firstName}/{lastName}")
	public ResponseEntity<String> getCustomGreeting(@PathVariable String firstName, @PathVariable String lastName){
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.body("hello"+firstName+""+lastName);
	}

}
