package com.example.spottyv2.api.SpringControllers;

import com.example.spottyv2.Controllers.MakePlaylistController;
import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.api.Serializer.Serializer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */

@Controller
@ControllerAdvice
public class WebInputController {


    @RequestMapping(value="/PlayGen", method = RequestMethod.POST)
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
            Serializer write = new Serializer();
            write.serialize(playlist);

            //Logging to console
            out = playlist.toString();
            attributes.addFlashAttribute("playlist", playlist);


        } else{
            out = "failed";
        }
        System.out.println(out);
        return new RedirectView("/result", true);
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView result(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("playlistResult");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) {
            Playlist playlist = (Playlist) inputFlashMap.get("playlist");
            //Console logging for debugging
            System.out.println("Result: " + playlist);

            modelAndView.addObject("playlist", playlist.toString());
            return modelAndView;
        }else {
            return null;
        }

    }

    @GetMapping(value = "/manage")
    @ResponseBody
    public ModelAndView manage(){
        ModelAndView modelAndView = new ModelAndView("manage");
        //TODO: This needs to be moved to either a helper method or use case class. (For clean architecture)
        Serializer getter = new Serializer();
        HashMap<String, String> out = new HashMap<>();
        ArrayList<Playlist> playlists = getter.getPlaylists(); //TODO: BAD TO MANIPULATE ENTITY
        for(Playlist playlist : playlists){
            out.put(playlist.getPlaylistName(), playlist.toString());
        }
        modelAndView.addObject("playlistMap", out);

        //Console logging for debugging
        System.out.println("All playlists:\n" + out);

        return modelAndView;

    }
    //TODO: Remove this method and incorporate the streaming into monitoring the outputs from song generator.
    @RequestMapping("/testing")
    public ResponseEntity<StreamingResponseBody> handleRequest2() {
        PrintStream previousConsole = System.out;
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));


        StreamingResponseBody stream = out -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("test" + i);
                out.write((newConsole + "-").getBytes());
                out.flush();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        System.setOut(previousConsole);
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(stream);
    }


}
