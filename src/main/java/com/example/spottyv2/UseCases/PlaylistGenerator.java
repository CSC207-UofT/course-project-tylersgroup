package com.example.spottyv2.UseCases;
/*
 * PlaylistGenerator takes in the string of user input and generates a playlist of songs
 */



import com.example.spottyv2.Entities.Playlist;

import java.util.ArrayList;

public class PlaylistGenerator {
    private PlaylistGenerationStrategy strategy;

    /**
     * Generates a playlist given a String ArrayList of words. For every element in words, if the song is found then
     * a new spotify track object is created representing that song, and is added to the new playlist.
     * @param words ArrayList of Strings representing the user's input.
     * @return Spotty Playlist object representation nof the user's input. Don't want to create a spotify playlist object
     * as it's not necessarily true that the user is going to want to add that playlist to their spotify library.
     */
    public Playlist generatePlaylistWeb(ArrayList<String> words) {
        String playlistName = PlaylistGenerator.buildPlaylistName(words);
        Playlist newPlaylist = new Playlist(playlistName);
        return this.strategy.generatePlaylistWeb(words, newPlaylist);
    }

    public void setStrategy(PlaylistGenerationStrategy strategy) {
        this.strategy = strategy;
    }

    private static String buildPlaylistName(ArrayList<String> words){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++){
            sb.append(words.get(i));
            sb.append(" ");
        }
        return sb.toString();


    }
}
