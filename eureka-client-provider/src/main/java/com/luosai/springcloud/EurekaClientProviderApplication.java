package com.luosai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientProviderApplication {
	private AtomicInteger count = new AtomicInteger() ;

	@RequestMapping("/hello")
	public String hello(){
		System.out.println("hello: "+count.getAndIncrement());
		return "hello";
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientProviderApplication.class, args);
	}
}
