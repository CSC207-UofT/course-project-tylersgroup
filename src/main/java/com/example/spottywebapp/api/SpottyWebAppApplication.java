package com.example.spottywebapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan("com.example.spottywebapp")
@ComponentScan(basePackages={"com.example.spottywebapp"})


public class SpottyWebAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpottyWebAppApplication.class, args);
    }
}
