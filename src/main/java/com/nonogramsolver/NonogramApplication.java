package com.nonogramsolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class NonogramApplication {

	public static void main(String[] args) {
		SpringApplication.run(NonogramApplication.class, args);
	}

}
