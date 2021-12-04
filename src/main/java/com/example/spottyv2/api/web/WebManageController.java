package com.example.spottyv2.api.web;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.api.Serializer.Serializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Springboot controller for displaying the user's list of playlists.
 */

@Controller
public class WebManageController {


    @GetMapping(value = {"/manage", "/manage/?id={id}"})
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
}
