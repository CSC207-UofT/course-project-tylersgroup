package com.example.spottywebapp.api.controller;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
//import com.sun.el.parser.ParseException;
import com.wrapper.spotify.model_objects.specification.*;
import com.wrapper.spotify.requests.data.personalization.simplified.GetUsersTopTracksRequest;
import com.wrapper.spotify.requests.data.playlists.CreatePlaylistRequest;
import com.wrapper.spotify.requests.data.playlists.GetListOfUsersPlaylistsRequest;
import com.wrapper.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.spottywebapp.api.controller.SpotifyAuthController.spotifyApi;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class SpotifyApiController {

    @GetMapping(value = "user-top-songs")
    public Track[] getUserTopTracks() {

        final GetUsersTopTracksRequest getUsersTopTracksRequest = spotifyApi.getUsersTopTracks()
                .time_range("medium_term")
                .limit(10)
                .offset(5)
                .build();

        try {

            final Paging<Track> trackPaging = getUsersTopTracksRequest.execute();

            // return top Tracks as JSON
            return trackPaging.getItems();
        } catch (Exception e) {
            System.out.println("Something went wrong!\n" + e.getMessage());
        }
        return new Track[0];
    }

    /**
    //@GetMapping(value = "user-playlists")
    public PlaylistSimplified[] getUserPlaylists() {

        final GetListOfUsersPlaylistsRequest getListOfUsersPlaylistsRequestRequest = spotifyApi.getListOfUsersPlaylists();

        try {

            final Paging<PlaylistSimplified> playlistSimplifiedPaging = getListOfUsersPlaylistsRequestRequest.execute();

            // return Playlists as JSON
            return playlistSimplifiedPaging.getItems();
        } catch (Exception e) {
            System.out.println("Something went wrong!\n" + e.getMessage());
        }
        return new PlaylistSimplified[0];
    }

    //@PostMapping(value = "create-playlist")
    public PlaylistSimplified createNewPlaylist(String user_id, String name){
        final CreatePlaylistRequest createNewPlaylistRequest = spotifyApi.createPlaylist(user_id, name);
    }


    public static void getCurrentUsersProfile_Sync() {
        final GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile()
                .build();
        try {
            final User user = getCurrentUsersProfileRequest.execute();

            System.out.println("Display name: " + user.getDisplayName());
        } catch (IOException | SpotifyWebApiException | ParseException e) { //TODO: Fix ParseException not importing
            System.out.println("Error: " + e);
        }
    }
    **/
}