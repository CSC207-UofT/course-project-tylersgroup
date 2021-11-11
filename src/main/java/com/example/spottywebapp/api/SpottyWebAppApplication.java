package com.example.spottywebapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.beans.factory.annotation.Autowired;
import com.example.spottywebapp.cli.PlaylistRepository;

@SpringBootApplication
@EntityScan("com.example.spottywebapp.api")
public class SpottyWebAppApplication {

    //@Autowired
    PlaylistRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(SpottyWebAppApplication.class, args);
    }

}
