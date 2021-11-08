package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.LongestPlaylistGenerator;
import com.example.spottywebapp.UseCases.PlaylistGenerationStrategy;
import com.example.spottywebapp.UseCases.PlaylistGenerator;
import com.example.spottywebapp.Entities.Playlist;
import com.example.spottywebapp.UseCases.ShortestPlaylistGenerator;
import com.example.spottywebapp.UseCases.PlaylistManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A controller class
 *
 * MakePlaylistController makes a playlist
 */
public class MakePlaylistController {
    private boolean complete;
    private static HashMap<String, PlaylistGenerationStrategy> playlistGenerationStrategyMap;
    public static void main(String[] args) {
        playlistGenerationStrategyMap.put("shortest", new ShortestPlaylistGenerator());
        playlistGenerationStrategyMap.put("longest", new LongestPlaylistGenerator());
        playlistGenerationStrategyMap.put("random", new ShortestPlaylistGenerator());
    }

    /**
     * Empty Constructor for createPlaylistHandler.
     */
    public MakePlaylistController(){
        this.complete = false;
        HashMap<String, PlaylistGenerationStrategy> playlistGenerationStrategyMap = new HashMap<>();
//
//        this.playlistGenerationStrategyMap = playlistGenerationStrategyMap;
    }

    /**
     * makePlaylist takes the user's string input and calls on UserInputProcessor to split the string into a form
     * that PlaylistGenerator can handle to generate a playlist.
     * @param input The user input string to generate a playlist from.
     */
    public static String makePlaylist(String input, String strategy, String username){
        ArrayList<String> words = UserInputController.splitUserInput(input);
        PlaylistGenerator playlistGenerator = new PlaylistGenerator();
        playlistGenerator.setStrategy(playlistGenerationStrategyMap.get(strategy));
        Playlist newPlaylist = playlistGenerator.generatePlaylist(words);
        // Add playlist to the user's list of playlists, of course
        PlaylistManager PLAYLISTMANAGER = PlaylistManager.getInstance();
        PLAYLISTMANAGER.addPlaylist(newPlaylist, username);
        return newPlaylist.toString();

    }

    public boolean getComplete() {
        return this.complete;

    }
}
