package com.borodich.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.borodich")
@EntityScan(basePackages = "com.borodich.entity")
@EnableJpaRepositories("com.borodich.dao.api")
public class Run {

    public static void main(String[] args) {
	SpringApplication.run(Run.class, args);
    }

}