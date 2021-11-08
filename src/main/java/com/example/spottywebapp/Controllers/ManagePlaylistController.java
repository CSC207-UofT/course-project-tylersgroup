package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.PlaylistManager;
import com.example.spottywebapp.Entities.User;

public class ManagePlaylistController {
    // Default constructor

    // TODO: Static or create new object?
    public static void callingRenamePlaylist(int playlistIndex, User user, String newName){
        PlaylistManager.renamePlaylist(playlistIndex, user, newName);
    }

    public static void callingRemovePlaylist(int playlistIndex, User user){
        PlaylistManager.removePlaylist(playlistIndex, user);
    }

    public static void printUserPlaylist(User user){
        PlaylistManager.printUserPlaylist(user);
    }
}
