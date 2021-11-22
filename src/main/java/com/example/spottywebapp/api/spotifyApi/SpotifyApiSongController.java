package com.example.spottywebapp.api.spotifyApi;


import com.neovisionaries.i18n.CountryCode;
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

    /**
     * Searches song in spotify database
     * @param songName string of song we want to find
     * @return if it exists, returns a song with the same songName.
     */

    @GetMapping(value = "search-song")
    public static Track searchSong(String songName){
        String capitalizedSongName = toTitleCase(songName);
//        final SearchTracksRequest searchTracksRequest =
//                spotifyApi.searchTracks("\""+songName+"\"")
//                //.limit(50)
//                //.offset(25)
//                .build();

        try{
            int offset_temp = 1;
            while(offset_temp < 1000) {
                final SearchTracksRequest searchTracksRequest =
                        spotifyApi.searchTracks("\"" + capitalizedSongName + "\"")
                                .market(CountryCode.CA)
                                .limit(50)
                                .offset(offset_temp)
                                .build();
                final Paging<Track> trackPaging = searchTracksRequest.execute();
                Track[] found_tracks = trackPaging.getItems();
                for(Track i:found_tracks){
                    System.out.println(i.getName());
                    if((i.getName()).equals(capitalizedSongName)){
                        return i;
                    }
                }
                offset_temp += 50;
                System.out.println("check");
                //return trackPaging.getItems()[0];
            }
        } catch (IOException | SpotifyWebApiException | ParseException e){
            System.out.print("Error: " + e.getMessage());
        }
        return null; //song not found

    }

    /**
     * Helper method to make strings into title case for spotify search algorithm to work better.
     * @param input String we want to put into title case
     * @return input string in title case form
     */

    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }



}
