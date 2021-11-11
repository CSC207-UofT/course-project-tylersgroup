package com.example.spottywebapp.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebInputController {

    @GetMapping("/WebInput")
    public String sendForm(WebInput input){
        return "WebInput";
    }

    @PostMapping("/WebInput")
    public String processForm(WebInput input){
        return "result";
    }


}
