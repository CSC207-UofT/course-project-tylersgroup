package com.example.spottywebapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
@EntityScan("com.example.spottywebapp")

public class SpottyWebAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpottyWebAppApplication.class, args);
    }
}
