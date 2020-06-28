package com.shiva.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.shiva.controller", "com.shiva.repository","com.shiva.model"})
public class CityRestApiCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityRestApiCrudApplication.class, args);
	}

}
