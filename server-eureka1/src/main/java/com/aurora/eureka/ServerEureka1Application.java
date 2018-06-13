package com.aurora.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//启用Eureka服务SpringBootServletInitializer
public class ServerEureka1Application{

	
	public static void main(String[] args) {
		SpringApplication.run(ServerEureka1Application.class, args);
	}
}
