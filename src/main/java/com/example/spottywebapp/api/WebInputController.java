package com.example.spottywebapp.api;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice
public class WebInputController {


    @RequestMapping(value="/PlayGen", method = RequestMethod.POST)
    public @ResponseBody String submitForm(@ModelAttribute("WebInput") WebInput input) {
        if (input.isValid()) {
            System.out.println(input); //Logging to console for testing purposes
        }
        return "result.html";
    }


}
