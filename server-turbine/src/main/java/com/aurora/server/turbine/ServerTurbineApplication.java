package com.aurora.server.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class ServerTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerTurbineApplication.class, args);
	}
}
