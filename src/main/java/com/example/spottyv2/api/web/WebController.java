package com.example.spottyv2.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO: Add javadoc!

@Controller
public class WebController {

    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value ="/PlayGen")
    public String PlayGen(){
        return "PlayGen";
    }

  }

