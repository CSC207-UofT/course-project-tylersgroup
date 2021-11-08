package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.PlaylistManager;

import com.example.spottywebapp.Entities.User;


/**
 * A controller class
 *
 * ManagePlaylistController works with the UI to manager playlists of all users.
 */
public class ManagePlaylistController {
    // Default constructor

    /**
     * Renames a playlist of the list of playlists of the user.
     * This method is only used by the UI
     * @param playlistIndex the index of the playlist from the playlists of the user
     * @param username username of user
     * @param newName the new name of the playlist
     */
    public static void callingRenamePlaylist(int playlistIndex, String username, String newName){
        PlaylistManager.renamePlaylist(playlistIndex, username, newName);
    }

    /**
     * Removes a playlist from the list of playlists of the user.
     * This method is only used by the UI
     * @param playlistIndex the index of the playlist from the playlists of the user
     * @param username username of user
     */
    public static void callingRemovePlaylist(int playlistIndex, String username){
        PlaylistManager.removePlaylist(playlistIndex, username);
    }

    /**
     * Prints all user's playlist
     * @param username username of user
     */
    public static void printUserPlaylist(String username){
        PlaylistManager.printUserPlaylist(username);
    }
}
