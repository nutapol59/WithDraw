package com.ss;

import com.ss.domain.Company;
import com.ss.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class WithdrawApplication {
	private static final Logger log = LoggerFactory.getLogger(WithdrawApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(WithdrawApplication.class, args);


	}




}
