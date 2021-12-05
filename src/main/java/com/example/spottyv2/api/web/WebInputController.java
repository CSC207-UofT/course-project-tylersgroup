package com.example.spottyv2.api.web;

import com.example.spottyv2.Controllers.MakePlaylistController;
import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.api.Serializer.JsonSerializer;
import com.example.spottyv2.api.Serializer.Serializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 */

@Controller
@ControllerAdvice
public class WebInputController {


    @RequestMapping(value={"/PlayGen"}, method = RequestMethod.POST)
    public @ResponseBody
    RedirectView submitPost(HttpServletRequest request,
                            @ModelAttribute("WebInput") WebInput input,
                            RedirectAttributes attributes) {

        String out;
        Playlist playlist;

        if (input.isValid()) {

            System.out.println(input); //Logging to console for testing purposes
            //Initialize controller to create playlist
            MakePlaylistController MakePlaylist = new MakePlaylistController();

            if (input.getNum() == 1){
                //Generating playlist with "longest" strategy
                playlist = MakePlaylist.makePlaylistWeb(input.getInput(), "longest");
            } else {
                //Generating playlist with "shortest" strategy
                playlist = MakePlaylist.makePlaylistWeb(input.getInput(), "shortest");
            }
            //Initialize gateway class
            JsonSerializer serializer = new JsonSerializer();
            serializer.savePlaylistToUser(serializer.loggedInUserInfo(input.getId()), playlist);
            //Serializer write = new Serializer();
            //write.serialize(playlist);

            //Logging to console
            out = playlist.toString();
            attributes.addFlashAttribute("playlist", playlist);


        } else{
            out = "failed";
        }
        System.out.println("Generated Playlist: " + out);
        System.out.println("Process finished.");
        System.out.println("Closing...");
        return new RedirectView(String.format("/result?id=%s", input.getId()), true);
    }


}
