package com.example.spottyv2.api.spotifyApi;

import com.example.spottyv2.api.web.ManagerContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SpotifyAPIToSpotify {

    @RequestMapping(value={"/saveToSpotify"}, method = RequestMethod.POST)
    public @ResponseBody
    RedirectView saveToSpotify(HttpServletRequest request,
                               @ModelAttribute("ManagerContainer") ManagerContainer container){
        SpotifyApiPlaylistController saver = new SpotifyApiPlaylistController();

        String uriString = container.getPlaylistURIs();
        String newuriString = uriString.substring( 1, uriString.length() - 1 );



        String[] songUris = newuriString.split(", ");

        saver.SavePlaylistToSpotify(container.getID(), container.getName(), songUris);
        return new RedirectView(String.format("/manage?id=%s", container.getID()), true);

    }


}
