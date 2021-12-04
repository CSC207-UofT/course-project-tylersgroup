package com.example.spottyv2.api.web;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.api.Serializer.JsonSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Springboot Controller for displaying the result of the generated playlist to the user.
 */

@Controller
public class WebResultController {

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView result(HttpServletRequest request){
        //TODO: Add mapping for shareable links to spotify playlists.
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

}
