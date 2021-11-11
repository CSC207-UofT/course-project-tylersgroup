package com.example.spottywebapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value="/home")
    public String goHome() {
        return "home"; // this returns the template name to be rendered from resources/templates. You don't need to provide the extension.
    }
}
