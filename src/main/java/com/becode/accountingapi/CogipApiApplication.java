package com.becode.accountingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.becode")
public class CogipApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CogipApiApplication.class, args);
    }
}
