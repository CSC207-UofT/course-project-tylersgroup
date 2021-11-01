package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.PlaylistGenerator;
import com.example.spottywebapp.entities.Playlist;

import java.util.ArrayList;

public class makePlaylistController {
    private boolean complete;

    /**
     * Empty Constructor for createPlaylistHandler.
     */
    public makePlaylistController(){
        this.complete = false;
    }

    /**
     * makePlaylist takes the user's string input and calls on UserInputProcessor to split the string into a form
     * that PlaylistGenerator can handle to generate a playlist.
     * @param input The user input string to generate a playlist from.
     */
    public String makePlaylist(String input){
        ArrayList<String> splitInput = UserInputController.splitUserInput(input);

        Playlist newPlaylist = PlaylistGenerator.generatePlaylist(splitInput);

        return newPlaylist.toString();


    }

    public boolean getComplete() {
        return this.complete;
    }
}
