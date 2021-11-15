package com.example.spottywebapp.api.web;

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

    @RequestMapping(value ="/PlayGen")
    public String PlayGen(){
        return "PlayGen.html";
    }

//    @GetMapping(value = "/result")
//        public String result(){
//            return "playlistResult.html";
//        }


  }

