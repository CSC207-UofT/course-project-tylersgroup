package com.example.spottywebapp.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class WebController {

    @GetMapping(value = "/home")
    public String home() {
        return "home.html";
    }

    @GetMapping(value ="/PlayGen")
    public String PlayGen(){
        return "PlayGen.html";
    }

}
