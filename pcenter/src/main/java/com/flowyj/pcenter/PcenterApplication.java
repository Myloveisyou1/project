package com.flowyj.pcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PcenterApplication {

	public static void main(String[] args) {

		SpringApplication.run(PcenterApplication.class, args);
	}
}
