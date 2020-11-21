package com.fashion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(basePackages = "com.fashion.Feign")
@SpringBootApplication 
public class CFashionApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CFashionApplication.class, args);
	}

}
