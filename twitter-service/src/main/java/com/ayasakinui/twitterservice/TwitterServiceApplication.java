package com.ayasakinui.twitterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TwitterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterServiceApplication.class, args);
	}

}
