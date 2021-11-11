package com.example.spottywebapp.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @GetMapping(value = "/home")
    public String home() {
        return "home.html";
    }

    @GetMapping(value ="/PlayGen")
    public String WebInput(){
        return "PlayGen.html";
    }


}
