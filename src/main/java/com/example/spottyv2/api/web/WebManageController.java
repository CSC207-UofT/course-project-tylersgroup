package com.example.spottyv2.api.web;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.api.Serializer.JsonSerializer;
import com.example.spottyv2.api.Serializer.Serializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Springboot controller for displaying the user's list of playlists.
 */

@Controller
public class WebManageController {


    @GetMapping(value = {"/manage", "/manage/?id={id}"})
    @ResponseBody
    public ModelAndView manage(@PathVariable(required = false, name="id") String id){
        ModelAndView modelAndView = new ModelAndView("manage");


        //TODO: This needs to be moved to either a helper method or use case class. (For clean architecture)
        //JsonSerializer getter = new JsonSerializer();
        Serializer getter = new Serializer();
        HashMap<String, String> out = new HashMap<>();
        //ArrayList<Playlist> playlists = getter.getPlaylists(getter.loggedInUserInfo(id));
        ArrayList<Playlist> playlists = getter.getPlaylists();
        List<String> headers = Arrays.asList("Playlist Name", "Playlist", "Add to your spotify", "Get shareable link");
        List<Map<String, Object>> rows = new ArrayList<>();
        String userID = "alphaturtle3621";

//        for(Playlist playlist : playlists){
//            out.put(playlist.getPlaylistName(), playlist.toString());
//
//            rows.add(Map.of("Playlist Name", playlist.getPlaylistName(), "Playlist", playlist.toString(),
//                    "Add to your spotify",
//
//                    "<form>" + "<input type=\"hidden\" id=\"id\" name=\"id\"" + " value=\"" + "Alphaturtle3621"
//                            + "\" "+
//                            "<input type=\"hidden\" id=\"name\" name=\"name\"" + " value=\"" + playlist.getPlaylistName()
//                            + "\" "+
//                            "<input type=\"hidden\" id=\"playlist\" name=\"playlist\"" + " value=\"" + "${"
//                            + "\" "+
//                            "</form>"
//
//                    , "Get shareable link", "N/A"));
//        }
        //modelAndView.addObject("playlistMap", out);


        modelAndView.addObject("headers", headers);
        modelAndView.addObject("playlistList", playlists);
        modelAndView.addObject("userID", userID);
        //modelAndView.addObject("rows", rows);

        //Console logging for debugging
        System.out.println("All playlists:\n" + out);

        return modelAndView;

    }
}
