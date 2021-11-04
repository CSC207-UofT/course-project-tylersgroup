package com.example.spottywebapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.spottywebapp.api")
public class SpottyWebAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpottyWebAppApplication.class, args);
    }
}
