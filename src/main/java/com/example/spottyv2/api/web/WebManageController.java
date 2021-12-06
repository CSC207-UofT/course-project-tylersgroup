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


//    @RequestMapping(value = {"/manage","/manage?id={id}",  "/manage/{id}"}, method = RequestMethod.GET)
//
//    public ModelAndView manage(@PathVariable(required = false) String id, @RequestParam String id2) {
//
//        ModelAndView modelAndView = new ModelAndView("manage");
//        System.out.println("Id: " + id);
//        System.out.println("ID2: " + id2);
//
//
//        //TODO: This needs to be moved to either a helper method or use case class. (For clean architecture)
//        JsonSerializer getter = new JsonSerializer();
//        //Serializer getter = new Serializer();
//        HashMap<String, String> out = new HashMap<>();
//        ArrayList<Playlist> playlists = getter.getPlaylists(getter.loggedInUserInfo(id));
//        //ArrayList<Playlist> playlists = getter.getPlaylists();
//        List<String> headers = Arrays.asList("Playlist Name", "Playlist", "Add to your spotify", "Get shareable link");
//        List<Map<String, Object>> rows = new ArrayList<>();
//        //String userID = "alphaturtle3621";
//
////        for(Playlist playlist : playlists){
////            out.put(playlist.getPlaylistName(), playlist.toString());
////
////            rows.add(Map.of("Playlist Name", playlist.getPlaylistName(), "Playlist", playlist.toString(),
////                    "Add to your spotify",
////
////                    "<form>" + "<input type=\"hidden\" id=\"id\" name=\"id\"" + " value=\"" + "Alphaturtle3621"
////                            + "\" "+
////                            "<input type=\"hidden\" id=\"name\" name=\"name\"" + " value=\"" + playlist.getPlaylistName()
////                            + "\" "+
////                            "<input type=\"hidden\" id=\"playlist\" name=\"playlist\"" + " value=\"" + "${"
////                            + "\" "+
////                            "</form>"
////
////                    , "Get shareable link", "N/A"));
////        }
//        //modelAndView.addObject("playlistMap", out);
//
//
//        modelAndView.addObject("headers", headers);
//        modelAndView.addObject("playlistList", playlists);
//        modelAndView.addObject("userID", id);
//        //modelAndView.addObject("rows", rows);
//
//        //Console logging for debugging
//        System.out.println("All playlists:\n" + out);
//
//        return modelAndView;
//
//    }

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
        ModelAndView mvc = new ModelAndView("manage");

        ArrayList<Playlist> playlists = getter.getPlaylists(getter.loggedInUserInfo(id));

        //console log test
        System.out.println("name: " + playlists.get(0).getPlaylistName());
        System.out.println("UriArray: " + playlists.get(0).getStringSongUri());

        mvc.addObject("playlistList", playlists);
        mvc.addObject("userID", id);


        return mvc;
        } else{
            return new ModelAndView("defaultManage");
        }

    }
}
