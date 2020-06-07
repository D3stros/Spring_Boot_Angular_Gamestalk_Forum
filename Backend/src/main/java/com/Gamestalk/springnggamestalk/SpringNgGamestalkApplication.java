package com.Gamestalk.springnggamestalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringNgGamestalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNgGamestalkApplication.class, args);
	}

}