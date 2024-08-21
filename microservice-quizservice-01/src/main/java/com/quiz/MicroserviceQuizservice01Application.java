package com.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceQuizservice01Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceQuizservice01Application.class, args);
	}

}
