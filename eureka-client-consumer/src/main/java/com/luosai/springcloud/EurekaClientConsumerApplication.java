package com.luosai.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientConsumerApplication {
	@Autowired
	RestTemplate restTemplate;
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@RequestMapping("/hello")
	public String hello(){
		return  restTemplate.getForObject("http://eureka-client-provider/hello", String.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientConsumerApplication.class, args);
	}
}
