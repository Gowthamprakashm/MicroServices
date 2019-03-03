package com.ekart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceClientApplication {

	@Autowired
	private EurekaClient client;

	@Autowired
	private RestTemplateBuilder template;

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
		System.out.println();
	}

	@GetMapping("/")
	public String callRegistrationService() {

		return restTemplate.getForEntity("http://EKART-REGISTRATIONSERVICE", String.class).getBody() +
		"-"	+ restTemplate.getForEntity("http://EKART-LOGINSERVICE", String.class).getBody() + 
		"-"	+ restTemplate.getForEntity("http://EKART-ITEMSERVICE", String.class).getBody();

	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();

	}

}
