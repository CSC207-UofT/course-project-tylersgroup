package com.example.spottyv2.api.web;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.api.Serializer.JsonSerializer;
import com.example.spottyv2.api.Serializer.Serializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Springboot controller for displaying the user's list of playlists.
 */

@RestController
@ControllerAdvice

public class WebManageController {


    @GetMapping(path = {"/manage", "/manage/{data}"})
    public ModelAndView user(@PathVariable(required=false,name="data") String data,
                     @RequestParam(required=false) Map<String,String> qparams) {
        qparams.forEach((a,b) -> {
            System.out.println(String.format("%s -> %s",a,b));
        });
        String id = qparams.get("id");

        if (data != null) {
            System.out.println(data);
        }
        JsonSerializer getter = new JsonSerializer();

        if (!getter.loggedInUserInfo(id).getDefaultUser()){
            try{
        ModelAndView mvc = new ModelAndView("manage");

        ArrayList<Playlist> playlists = getter.getPlaylists(getter.loggedInUserInfo(id));

        //console log test
        System.out.println("name: " + playlists.get(0).getPlaylistName());
        System.out.println("UriArray: " + playlists.get(0).getStringSongUri());

        mvc.addObject("playlistList", playlists);
        mvc.addObject("userID", id);


        return mvc;}
            catch (IndexOutOfBoundsException error){
                return new ModelAndView("noPlaylists");
            }
        } else{
            return new ModelAndView("defaultManage");
        }

    }
}
