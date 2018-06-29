package com.matrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringBootHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}
}
