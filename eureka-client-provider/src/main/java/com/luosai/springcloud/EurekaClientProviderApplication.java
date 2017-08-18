package com.luosai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientProviderApplication {

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientProviderApplication.class, args);
	}
}
