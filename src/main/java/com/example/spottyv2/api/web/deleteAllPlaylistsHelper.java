package com.example.spottyv2.api.web;

import com.example.spottyv2.api.Serializer.JsonSerializer;
import com.example.spottyv2.api.spotifyApi.SpotifyApiPlaylistController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class deleteAllPlaylistsHelper {

    @RequestMapping(value={"/deleteAll"}, method = RequestMethod.POST)
    public @ResponseBody
    RedirectView saveToSpotify(@ModelAttribute("ManagerContainer") ManagerContainer container){
        JsonSerializer serializer = new JsonSerializer();

        System.out.println("Playlists deleting for:" + container.getID());
        serializer.deleteUserPlaylists(serializer.loggedInUserInfo(container.getID()));

        return new RedirectView(String.format("/manage?id=%s", container.getID()), true);

    }


}
