package com.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
//@SpringBootApplication()
public class P1SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(P1SpringSecurityApplication.class, args);

		System.out.println("Hello World");
	}

}
	