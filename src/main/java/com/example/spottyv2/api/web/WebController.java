package com.example.spottyv2.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

//TODO: Add javadoc!

@Controller
public class WebController {
//    @GetMapping(value = "/home")
//    public String home() {
//        return "home";
//    }

    @GetMapping(path = {"/home", "/home?id={id}"})
    public String home(@PathVariable(required=false,name="id") String id,
                          @RequestParam(required=false) Map<String,String> qparams) {

        if (id != null) {
            System.out.println(id);
        }
        System.out.println(id);
        return "home";
    }

//
//    @RequestMapping(value ={"/PlayGen", "/PlayGen?id={id}"})
//    public String PlayGen(@PathVariable (required = true, name="id") String id){
//
//        return "PlayGen";
//    }

    @GetMapping(path = {"/PlayGen", "/PlayGen?id={id}"})
    public String PlayGen(@PathVariable(required=false,name="id") String id,
                     @RequestParam(required=false) Map<String,String> qparams) {
        for (Map.Entry<String, String> entry : qparams.entrySet()) {
            String a = entry.getKey();
            String b = entry.getValue();
            System.out.println(String.format("%s -> %s", a, b));
        }
        if (id != null) {
            System.out.println(id);
        }
        return "PlayGen";
    }
  }

