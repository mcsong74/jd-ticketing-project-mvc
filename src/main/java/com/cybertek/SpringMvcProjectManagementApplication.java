package com.cybertek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@SpringBootApplication
public class SpringMvcProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProjectManagementApplication.class, args);
		System.out.println("Hello");
	}




}
