package com.shiva.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.shiva.controller")
public class WeatherRestApiClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherRestApiClientApplication.class, args);
	}

}
