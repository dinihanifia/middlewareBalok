package com.svc.mw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SvcMwApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcMwApplication.class, args);
	}
}
