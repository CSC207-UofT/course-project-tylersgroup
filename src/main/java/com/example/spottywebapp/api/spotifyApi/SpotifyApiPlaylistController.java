package com.example.spottywebapp.api.spotifyApi;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.special.SnapshotResult;
import com.wrapper.spotify.model_objects.specification.*;
import com.wrapper.spotify.requests.data.playlists.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.JsonArray;
import org.apache.hc.core5.http.ParseException;

import static com.example.spottywebapp.api.spotifyApi.SpotifyAuthController.spotifyApi;
import java.io.IOException;

public class SpotifyApiPlaylistController {

    @GetMapping(value = "user-playlists")
    public PlaylistSimplified[] getCurrentUserPlaylists(String user_id) {

        final GetListOfCurrentUsersPlaylistsRequest getListOfUsersPlaylistsRequest =
                spotifyApi.getListOfCurrentUsersPlaylists()
                .build();

        try {

            final Paging<PlaylistSimplified> playlistSimplifiedPaging = getListOfUsersPlaylistsRequest.execute();

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
        final ChangePlaylistsDetailsRequest changePlaylistsDetailsRequest =
                spotifyApi.changePlaylistsDetails(playlistId)
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
        final GetPlaylistRequest getPlaylistRequest =
                spotifyApi.getPlaylist(playlistId)
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
        final GetPlaylistsItemsRequest getPlaylistsItemsRequest =
                spotifyApi.getPlaylistsItems(playlistId)
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
}
