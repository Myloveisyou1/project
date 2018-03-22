package com.jiemin.wages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class WagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WagesApplication.class, args);
		System.out.println("========启动成功1==========");
	}
}
