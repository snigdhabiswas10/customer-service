package com.service.customerservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.service")
public class CustomerServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServicesApplication.class, args);
	}

}
