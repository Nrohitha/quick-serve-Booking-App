package com.example.quickserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.quickserve")
public class QuickserveApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickserveApplication.class, args);
    }
}