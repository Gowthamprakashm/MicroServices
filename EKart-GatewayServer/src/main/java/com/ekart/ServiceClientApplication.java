package com.ekart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableZuulProxy
public class ServiceClientApplication {



	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
		System.out.println();
	}


}
