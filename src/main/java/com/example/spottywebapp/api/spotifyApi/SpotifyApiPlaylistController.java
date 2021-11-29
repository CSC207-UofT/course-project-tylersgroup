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

    /**
     * Get current user's list of playlists
     * @param user_id current userID
     * @return array of simplified playlist objects
     */

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

    /**
     * Creates a new playlist to the user's account
     * @param userId current user's ID
     * @param name New playlist's name in form of a string.
     */
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


    /**
     * changes the playlist name
     * @param playlistId the string id of the playlist whose name we want to change
     * @param newName the name we want to change the playlist name to.
     */

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

    /**
     * Returns a playlist from the list of user playlists.
     * @param playlistId playlist id we of the playlist we want returned.
     */
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

    /**
     * Returns items in a given playlist, usually of type song
     * @param playlistId playlist id of which we want to see the songs of.
     */
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

    /**
     * removes an array of tracks from a given playlist
     * @param playlistId Id of playlist we want to remove tracks from
     * @param tracks JSON aray of tracks we want to remove.
     */
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

    /**
     * Adds given items to playlist
     * @param playlist_id playlist we want to add items to
     * @param uris uris of songs we want to add (need to implement getItemUri method)
     */
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

    /**
     * Adds item to playlist with a given position.
     * @param playlist_id id of playlist we want to add items to
     * @param uris uris of songs we want to add
     * @param position position from where we want to add these songs.
     */

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
