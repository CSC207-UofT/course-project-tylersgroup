package com.example.spottyv2.Controllers;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.UseCases.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A controller class
 *
 * MakePlaylistController makes a playlist
 */
public class MakePlaylistController {
    private boolean complete;
    private HashMap<String, PlaylistGenerationStrategy> playlistGenerationStrategyMap;

    /**
     * Empty Constructor for createPlaylistHandler.
     */
    public MakePlaylistController(){
        this.complete = false;
        HashMap<String, PlaylistGenerationStrategy> playlistGenerationStrategyMap = new HashMap<>();
        playlistGenerationStrategyMap.put("shortest", new ShortestPlaylistGenerator());
        playlistGenerationStrategyMap.put("longest", new LongestPlaylistGenerator());
        playlistGenerationStrategyMap.put("random", new ShortestPlaylistGenerator());
        this.playlistGenerationStrategyMap = playlistGenerationStrategyMap;
    }


    /**
     * WEB Controller testing version of makePlaylist without user saving functionality.
     * @param input input string to generate playlist
     * @param strategy method by which playlist generation occurs.
     * @return returns a string representation of the playlist.
     */
    public Playlist makePlaylistWeb(String input, String strategy) {

        ArrayList<String> words = UserInputController.splitUserInput(input);
        PlaylistGenerator playlistGenerator = new PlaylistGenerator();
        playlistGenerator.setStrategy(this.playlistGenerationStrategyMap.get(strategy));
        return playlistGenerator.generatePlaylistWeb(words);
    }

}
