package com.example.spottywebapp.api.spotifyApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.User;
import com.wrapper.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import static com.example.spottywebapp.api.spotifyApi.SpotifyAuthController.spotifyApi;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;



public class SpotifyUserController {
    // whenever a new user logs in, create a new user object for this user, need a constructor for user.
    public static User currentUser;
    /**
     * Returns a User object for the currently logged in user.
     */
    public static final GetCurrentUsersProfileRequest getCurrentUsersProfileReq = spotifyApi.getCurrentUsersProfile()
            .build();
    /**
     * Constructs User object representing the currently logged-in user, allowing us to use the following:
     * currentUser.getId, currentUser.getExternalUrls, currentUser.getUri, currentUser.getDisplayName
     * @return User Object representing currently logged-in user.
     */
    @GetMapping(value = "get-current-user")
    @ResponseBody
    public static User getCurrentUser(){
        //constructs current user
        try{
            currentUser = getCurrentUsersProfileReq.execute();
            return currentUser;
        }
        catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }



    @GetMapping(value = "get-current-user-id")
    @ResponseBody
    public String getCurrentUserId()
    {
        try{
            return currentUser.getId();
        }
        catch (NullPointerException e ) {
            System.out.println("No user is currently logged in.");
            return null;
        }
    }

    @GetMapping
    @ResponseBody
    public String getCurrentUserName() {
        return currentUser.getDisplayName();
    }

    @GetMapping
    @ResponseBody
    public String getCurrentUserUri() {
        return currentUser.getUri();
    }

}
