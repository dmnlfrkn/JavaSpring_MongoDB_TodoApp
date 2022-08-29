package com.todoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TodoAppMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppMongodbApplication.class, args);
	}

}