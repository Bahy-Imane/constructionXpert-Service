package com.ressources.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RessourcesManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RessourcesManagerApplication.class, args);
	}

}
