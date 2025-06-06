package com.example.notification_api_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NotificationApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApiServiceApplication.class, args);
	}

}
