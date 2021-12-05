package com.example.spottyv2.api.spotifyApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.User;
import com.wrapper.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import static com.example.spottyv2.api.spotifyApi.SpotifyAuthController.spotifyApi;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class SpotifyUserController {
    public static User currentUser;
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


    /**
     * Get the id representation of the currently logged-in user.
     * @return String id of currently logged-in user.
     */
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

    /**
     * Get username of currently logged-in user.
     * @return String of logged-in user's username
     */
    @GetMapping
    @ResponseBody
    public String getCurrentUserName() {
        return currentUser.getDisplayName();
    }

    /**
     * Get the Uri representation of the currently logged-in user.
     * @return String representing the currently logged-in user's profile Uri.
     */
    @GetMapping
    @ResponseBody
    public String getCurrentUserUri() {
        return currentUser.getUri();
    }

}