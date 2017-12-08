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

import java.util.concurrent.atomic.AtomicInteger;

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

	private AtomicInteger count = new AtomicInteger() ;
	private AtomicInteger count2 = new AtomicInteger() ;

	@RequestMapping("/hello")
	public String hello(){
		System.out.println("request:"+count2.getAndIncrement());
		String str =  restTemplate.getForObject("http://eureka-client-provider/hello", String.class);
		System.out.println(str+count.getAndIncrement());
		return str ;
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientConsumerApplication.class, args);
	}
}
