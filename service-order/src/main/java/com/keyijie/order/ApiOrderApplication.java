package com.keyijie.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.keyijie")
public class ApiOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiOrderApplication.class, args);
	}
}
