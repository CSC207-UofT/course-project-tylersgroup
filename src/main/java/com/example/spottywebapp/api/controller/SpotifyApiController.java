package com.example.spottywebapp.api.controller;

import com.wrapper.spotify.enums.ModelObjectType;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.special.SnapshotResult;
import com.wrapper.spotify.model_objects.specification.*;
import com.wrapper.spotify.requests.data.personalization.simplified.GetUsersTopTracksRequest;
import com.wrapper.spotify.requests.data.playlists.*;
import com.wrapper.spotify.requests.data.personalization.simplified.GetUsersTopArtistsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import com.wrapper.spotify.requests.data.users_profile.GetCurrentUsersProfileRequest;
import com.wrapper.spotify.model_objects.special.SearchResult;
import com.wrapper.spotify.requests.data.search.SearchItemRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.hc.core5.http.ParseException;

import static com.example.spottywebapp.api.controller.SpotifyAuthController.spotifyApi;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class SpotifyApiController {

    @GetMapping(value = "user-top-artists")
    public Artist[] getUserTopArtists() {

        final GetUsersTopArtistsRequest getUsersTopArtistsRequest = spotifyApi.getUsersTopArtists()
                .time_range("medium_term")
                .limit(10)
                .offset(5)
                .build();

        try {
            final Paging<Artist> artistPaging = getUsersTopArtistsRequest.execute();

            // return top artists as JSON
            return artistPaging.getItems();
        } catch (Exception e) {
            System.out.println("Something went wrong!\n" + e.getMessage());
        }
        return new Artist[0];
    }

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

    @GetMapping(value = "user-playlists")
    public PlaylistSimplified[] getCurrentUserPlaylists(String user_id) {

        final GetListOfCurrentUsersPlaylistsRequest getListOfUsersPlaylistsRequestRequest = spotifyApi.getListOfCurrentUsersPlaylists()
                .build();

        try {

            final Paging<PlaylistSimplified> playlistSimplifiedPaging = getListOfUsersPlaylistsRequestRequest.execute();

            // return Playlists as JSON
            return playlistSimplifiedPaging.getItems();
        } catch (Exception e) {
            System.out.println("Something went wrong!\n" + e.getMessage());
        }
        return new PlaylistSimplified[0];
    }

    @PostMapping(value = "create-playlist")
    public void createNewPlaylist(String userId, String name){
        final CreatePlaylistRequest createPlaylistRequest = spotifyApi.createPlaylist(userId, name)
                .build();
        try {
            final Playlist playlist = createPlaylistRequest.execute();

            System.out.println("Name: " + playlist.getName());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @PostMapping(value = "change-playlist-details")
    public void changePlaylistDetails(String playlistId, String newName){
        final ChangePlaylistsDetailsRequest changePlaylistsDetailsRequest = spotifyApi.changePlaylistsDetails(playlistId)
                .name(newName)
                .build();

        try {
            final String string = changePlaylistsDetailsRequest.execute();

            System.out.println("Null: " + string);
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    //can probably make a new method that gets you the playlist by playlist name but have this for the time being
    @GetMapping(value = "get-playlist")
    public void getPlaylist(String playlistId){
        final GetPlaylistRequest getPlaylistRequest = spotifyApi.getPlaylist(playlistId)
                .build();

        try {
            final Playlist playlist = getPlaylistRequest.execute();

            System.out.println("Name: " + playlist.getName());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @GetMapping(value = "get-playlist-items")
    public void getPlaylistItems(String playlistId){
        final GetPlaylistsItemsRequest getPlaylistsItemsRequest = spotifyApi.getPlaylistsItems(playlistId)
                .build();
        // can also add limit
        try {
            final Paging<PlaylistTrack> playlistTrackPaging = getPlaylistsItemsRequest.execute();

            System.out.println("Total: " + playlistTrackPaging.getTotal());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @PostMapping(value = "remove-items")
    public void removeItemsFromPlaylist(String playlistId, JsonArray tracks) {
        final RemoveItemsFromPlaylistRequest removeItemsFromPlaylistRequest = spotifyApi
                .removeItemsFromPlaylist(playlistId, tracks)
                .build();
        try {
            final SnapshotResult snapshotResult = removeItemsFromPlaylistRequest.execute();

            System.out.println("Snapshot ID: " + snapshotResult.getSnapshotId());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @PostMapping(value = "add-items-to-playlist")
    public void addItemsToPlaylist(String playlist_id, String[] uris){
        final AddItemsToPlaylistRequest addItemsToPlaylistRequest = spotifyApi.addItemsToPlaylist(playlist_id, uris)
                .build();

        try {
            final SnapshotResult snapshotResult = addItemsToPlaylistRequest.execute();

            System.out.println("Snapshot ID: " + snapshotResult.getSnapshotId());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @PostMapping(value = "add-items-to-playlist-position")
    public void addItemsToPlaylist(String playlist_id, String[] uris, int position){
        final AddItemsToPlaylistRequest addItemsToPlaylistRequest = spotifyApi.addItemsToPlaylist(playlist_id, uris)
                .position(position)
                .build();

        try {
            final SnapshotResult snapshotResult = addItemsToPlaylistRequest.execute();

            System.out.println("Snapshot ID: " + snapshotResult.getSnapshotId());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @GetMapping(value = "search-song")
    public static Track searchSong(String songName){
        final SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks("\""+songName+"\"")
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

    public static void getCurrentUsersProfile_Sync() {
        final GetCurrentUsersProfileRequest getCurrentUsersProfileRequest = spotifyApi.getCurrentUsersProfile()
                .build();
        try {
            final User user = getCurrentUsersProfileRequest.execute();

            System.out.println("Display name: " + user.getDisplayName());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e);
        }
    }
}