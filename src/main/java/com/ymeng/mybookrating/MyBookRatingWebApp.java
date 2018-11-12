package com.ymeng.mybookrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.ymeng.mybookrating"})
public class MyBookRatingWebApp {

	public static void main(String[] args) {
		SpringApplication.run(MyBookRatingWebApp.class, args);
	}
}
