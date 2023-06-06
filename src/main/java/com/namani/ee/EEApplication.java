package com.namani.ee;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(servers = {@Server(url = "https://2023-61-34-253-110.ngrok-free.app", description = "Default Server URL")})
@SpringBootApplication
public class EEApplication {

	public static void main(String[] args) {
		SpringApplication.run(EEApplication.class, args);
	}
}
