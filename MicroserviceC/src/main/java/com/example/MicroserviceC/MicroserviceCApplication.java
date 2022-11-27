package com.example.MicroserviceC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class MicroserviceCApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCApplication.class, args);
	}

	@Autowired
	Environment environment;

	@GetMapping("/")
	public String microserviceC() {
		System.out.println("Inside MyRestController::backend...");

		String serverPort = environment.getProperty("local.server.port");

		System.out.println("Port : " + serverPort);

		return "Microservice C: built-in ECs, Serving on PM  :: Port : " + serverPort;
	}

}
