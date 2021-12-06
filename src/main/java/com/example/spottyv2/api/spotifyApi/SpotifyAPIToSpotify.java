package com.example.spottyv2.api.spotifyApi;

import com.example.spottyv2.api.web.ManagerContainer;
import com.example.spottyv2.api.web.WebInput;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Playlist;
import com.wrapper.spotify.requests.data.playlists.CreatePlaylistRequest;
import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.example.spottyv2.api.spotifyApi.SpotifyAuthController.spotifyApi;
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
