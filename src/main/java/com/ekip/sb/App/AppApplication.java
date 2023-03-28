package com.ekip.sb.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.ekip.sb.App.controller" , "com.ekip.sb.App.service", "com.ekip.sb.App.repo", "com.ekip.sb.App.model"})
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

	}
}
