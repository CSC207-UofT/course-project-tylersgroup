package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.PlaylistGenerator;
import com.example.spottywebapp.UseCases.PlaylistManager;
import com.example.spottywebapp.entities.Playlist;

import java.util.ArrayList;

/**
 * A controller class
 *
 * MakePlaylistController makes a playlist
 */
public class MakePlaylistController {
    private boolean complete;

    /**
     * Empty Constructor for createPlaylistHandler.
     */
    public MakePlaylistController(){
        this.complete = false;
    }

    /**
     * makePlaylist takes the user's string input and calls on UserInputProcessor to split the string into a form
     * that PlaylistGenerator can handle to generate a playlist.
     * @param input The user input string to generate a playlist from.
     */
    public static String makePlaylist(String input, String username){
        ArrayList<String> splitInput = UserInputController.splitUserInput(input);

        Playlist newPlaylist = PlaylistGenerator.generatePlaylist(splitInput);

        // Add playlist to the user's list of playlists, of course
        PlaylistManager PLAYLISTMANAGER = PlaylistManager.getInstance();
        PLAYLISTMANAGER.addPlaylist(newPlaylist, username);
        return newPlaylist.toString();
    }
}
