package com.example.spottywebapp.api.spotifyApi;

import com.wrapper.spotify.requests.data.personalization.simplified.GetUsersTopTracksRequest;
import com.wrapper.spotify.model_objects.specification.*;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;

import static com.example.spottywebapp.api.spotifyApi.SpotifyAuthController.spotifyApi;
import org.apache.hc.core5.http.ParseException;
import java.io.IOException;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;

@RestController
@RequestMapping("/api")
public class SpotifyApiSongController {

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

    @GetMapping(value = "search-song")
    public static Track searchSong(String songName){
        final SearchTracksRequest searchTracksRequest =
                spotifyApi.searchTracks("\""+songName+"\"")
                //.limit(50)
                //.offset(25)
                .build();

        try{
            final Paging<Track> trackPaging = searchTracksRequest.execute();
            //Track[] found_tracks = trackPaging.getItems();
            //for(Track i:found_tracks){
            //if(i.getName().length() == songName.length()){
            //return i;
            //}
            //}
            return trackPaging.getItems()[0];
        } catch (IOException | SpotifyWebApiException | ParseException e){
            System.out.print("Error: " + e.getMessage());
        }
        return null; //song not found

    }

}
