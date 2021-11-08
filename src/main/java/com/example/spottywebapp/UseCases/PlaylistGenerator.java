package com.example.spottywebapp.UseCases;
/*
 * PlaylistGenerator takes in the string of user input and generates a playlist of songs
 */


import com.example.spottywebapp.Entities.Playlist;
import com.example.spottywebapp.Entities.Song;

import java.util.ArrayList;
import java.util.List;

public class PlaylistGenerator {
    private PlaylistGenerationStrategy strategy;
    public Playlist generatePlaylist(ArrayList<String> words) {
//        for (String s : words) {
//            Song song = SongGenerator.generateSong(s); //create a song entity for that song
//            // receive the song entities and instantiate a playlist entity
//            newPlaylist.addSong(song);
//        }
        return this.strategy.generatePlaylist(words);
    }

    public void setStrategy(PlaylistGenerationStrategy strategy) {
        this.strategy = strategy;
    }


}
