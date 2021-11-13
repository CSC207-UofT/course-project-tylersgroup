package com.example.spottywebapp.api;

import com.example.spottywebapp.Controllers.MakePlaylistController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice
public class WebInputController {


    @RequestMapping(value="/PlayGen", method = RequestMethod.POST)
    public @ResponseBody String submitForm(@ModelAttribute("WebInput") WebInput input) {
        String a;
        if (input.isValid()) {
            System.out.println(input); //Logging to console for testing purposes
            MakePlaylistController MakePlaylist = new MakePlaylistController();
            //String username = "testUser";
            if (input.getNum() == 1){
                a = MakePlaylist.makePlaylistWeb(input.getInput(), "longest");
            } else {
                a = MakePlaylist.makePlaylistWeb(input.getInput(), "shortest");
            }
            System.out.println(a);
        } else{
            a = "failed";
        }

        return a;
    }


}
