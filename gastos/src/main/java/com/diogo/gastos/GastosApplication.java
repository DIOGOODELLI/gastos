package com.diogo.gastos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan(basePackages = {"com.diogo.gastos"}) 
@ComponentScan(basePackages = {"com.diogo.gastos"}) 
@EnableJpaRepositories(basePackages = {"com.diogo.gastos"}) 
@EnableAutoConfiguration
@EnableScheduling
public class GastosApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(GastosApplication.class, args);
	}
}




