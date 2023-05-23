package com.nonogramsolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// @Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class NonogramApplication {

	public static void main(String[] args) {
		SpringApplication.run(NonogramApplication.class, args);
	}

}
