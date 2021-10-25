package Controllers;

import Entities.Playlist;
import UseCases.PlaylistGenerator;

import java.util.ArrayList;

public class createPlaylistHandler {
    private boolean complete;

    /**
     * Empty Constructor for createPlaylistHandler.
     */
    public createPlaylistHandler(){
        this.complete = false;
    }

    /**
     * makePlaylist takes the user's string input and calls on UserInputProcessor to split the string into a form
     * that PlaylistGenerator can handle to generate a playlist.
     * @param input The user input string to generate a playlist from.
     */
    public String makePlaylist(String input){
        ArrayList<String> splitInput = UserInputProcessor.splitUserInput(input);

        Playlist newPlaylist = PlaylistGenerator.generatePlaylist(splitInput);

        return newPlaylist.toString();


    }

    public boolean getComplete() {
        return this.complete;
    }
}
