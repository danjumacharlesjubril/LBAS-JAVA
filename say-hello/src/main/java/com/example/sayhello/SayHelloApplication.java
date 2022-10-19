package com.example.sayhello;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SayHelloApplication {
	@Value("${server.port}")
	private int port;
	private static Logger log = LoggerFactory.getLogger(SayHelloApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SayHelloApplication.class, args);
	}

	@GetMapping("/greeting")
	public String greet() {

		log.info("Access /greeting");

		List<String> greetings = Arrays.asList("Rendering from port:", "Rendering from port:", "Rendering from port:");
		Random rand = new Random();

		int randomNum = rand.nextInt(greetings.size());
		return greetings.get(randomNum) + " " + port;
	}

	@GetMapping("/")
	public String home() {
		log.info("Access /");
		return "Rendering from port:" + " " + port;
	}
}
