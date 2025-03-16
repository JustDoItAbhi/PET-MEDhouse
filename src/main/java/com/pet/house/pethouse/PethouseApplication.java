package com.pet.house.pethouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class PethouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PethouseApplication.class, args);
	}

}
