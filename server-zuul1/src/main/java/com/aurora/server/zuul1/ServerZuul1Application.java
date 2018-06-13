package com.aurora.server.zuul1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ServerZuul1Application {

	public static void main(String[] args) {
		SpringApplication.run(ServerZuul1Application.class, args);
	}
}
