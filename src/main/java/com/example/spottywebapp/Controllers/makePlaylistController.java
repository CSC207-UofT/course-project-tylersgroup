package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.LongestPlaylistGenerator;
import com.example.spottywebapp.UseCases.PlaylistGenerationStrategy;
import com.example.spottywebapp.UseCases.PlaylistGenerator;
import com.example.spottywebapp.Entities.Playlist;
import com.example.spottywebapp.UseCases.ShortestPlaylistGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class makePlaylistController {
    private boolean complete;
    private final HashMap<String, PlaylistGenerationStrategy> playlistGenerationStrategyMap;

    /**
     * Empty Constructor for createPlaylistHandler.
     */
    public makePlaylistController(){
        this.complete = false;
        HashMap<String, PlaylistGenerationStrategy> playlistGenerationStrategyMap = new HashMap<>();
        playlistGenerationStrategyMap.put("shortest", new ShortestPlaylistGenerator());
        playlistGenerationStrategyMap.put("longest", new LongestPlaylistGenerator());
        playlistGenerationStrategyMap.put("random", new ShortestPlaylistGenerator());
        this.playlistGenerationStrategyMap = playlistGenerationStrategyMap;
    }

    /**
     * makePlaylist takes the user's string input and calls on UserInputProcessor to split the string into a form
     * that PlaylistGenerator can handle to generate a playlist.
     * @param input The user input string to generate a playlist from.
     */
    public String makePlaylist(String input, String strategy){
        ArrayList<String> splitInput = UserInputController.splitUserInput(input);
        PlaylistGenerator playlistGenerator = new PlaylistGenerator();
        playlistGenerator.setStrategy(this.playlistGenerationStrategyMap.get(strategy));
        Playlist newPlaylist = playlistGenerator.generatePlaylist(splitInput);
        return newPlaylist.toString();
    }

    public boolean getComplete() {
        return this.complete;
    }
}
