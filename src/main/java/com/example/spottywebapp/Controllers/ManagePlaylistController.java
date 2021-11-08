package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.PlaylistManager;
import com.example.spottywebapp.Entities.User;

public class ManagePlaylistController {
    // Default constructor

    // TODO: Static or create new object?
    public static void callingRenamePlaylist(int playlistIndex, String username, String newName){
        PlaylistManager.renamePlaylist(playlistIndex, username, newName);
    }

    public static void callingRemovePlaylist(int playlistIndex, String username){
        PlaylistManager.removePlaylist(playlistIndex, username);
    }

    public static void printUserPlaylist(String username){
        PlaylistManager.printUserPlaylist(username);
    }
}
