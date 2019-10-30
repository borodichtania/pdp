package com.borodich.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.borodich")
@EntityScan(basePackages = "com.borodich.entity")
public class Run {

    public static void main(String[] args) {
	SpringApplication.run(Run.class, args);
    }

}