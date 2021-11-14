package com.example.spottywebapp.api;

import com.example.spottywebapp.Controllers.MakePlaylistController;
import com.example.spottywebapp.Entities.Playlist;
import com.example.spottywebapp.api.Serializer.Serializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@Controller
@ControllerAdvice
public class WebInputController {


    @RequestMapping(value="/PlayGen", method = RequestMethod.POST)
    public @ResponseBody String submitForm(@ModelAttribute("WebInput") WebInput input) {
        String out;
        Playlist playlist;

        if (input.isValid()) {
            System.out.println(input); //Logging to console for testing purposes
            MakePlaylistController MakePlaylist = new MakePlaylistController();
            //String username = "testUser";
            if (input.getNum() == 1){
                playlist = MakePlaylist.makePlaylistWeb(input.getInput(), "longest");
            } else {
                playlist = MakePlaylist.makePlaylistWeb(input.getInput(), "shortest");
            }
            Serializer write = new Serializer();
            write.serialize(playlist);

            //Logging to console
            out = playlist.toString();
            System.out.println(out);
        } else{
            out = "failed";
        }

        return out;
    }


}
