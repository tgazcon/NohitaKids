package com.example.nohitakids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class NohitaKidsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NohitaKidsApplication.class, args);
	}

}
