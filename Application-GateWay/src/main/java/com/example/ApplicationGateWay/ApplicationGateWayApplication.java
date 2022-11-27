package com.example.ApplicationGateWay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RibbonClient(name = "serverC", configuration = RibbonConfiguration.class)
public class ApplicationGateWayApplication {

	// private String id;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationGateWayApplication.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/microserviceA")
	public String microserviceA() {
		return  this.restTemplate.getForObject("http://serverA/", String.class);

	}

	@RequestMapping("/microserviceB")
	public String microserviceB() {
		return  this.restTemplate.getForObject("http://serverB/", String.class);

	}

	@RequestMapping("/microserviceC")
	public String microserviceC() {
		return  this.restTemplate.getForObject("http://serverC/", String.class);

	}
}
