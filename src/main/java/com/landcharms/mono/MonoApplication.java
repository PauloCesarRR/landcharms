package com.landcharms.mono;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAdminServer
public class MonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonoApplication.class, args);
	}

}
