package com.bws.tokenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TokenserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenserviceApplication.class, args);
	}

}
