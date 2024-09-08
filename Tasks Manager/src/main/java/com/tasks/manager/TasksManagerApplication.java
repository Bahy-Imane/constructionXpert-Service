package com.tasks.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TasksManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksManagerApplication.class, args);
	}

}
