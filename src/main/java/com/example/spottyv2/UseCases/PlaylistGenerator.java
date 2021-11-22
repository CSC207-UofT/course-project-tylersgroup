package com.example.spottyv2.UseCases;
/*
 * PlaylistGenerator takes in the string of user input and generates a playlist of songs
 */



import com.example.spottyv2.Entities.Playlist;

import java.util.ArrayList;

public class PlaylistGenerator {
    private PlaylistGenerationStrategy strategy;

    public Playlist generatePlaylist(ArrayList<String> words) {
        String playlistName = PlaylistGenerator.buildPlaylistName(words);
        Playlist newPlaylist = new Playlist(playlistName);
        return this.strategy.generatePlaylist(words, newPlaylist);
    }

    public Playlist generatePlaylistWeb(ArrayList<String> words) {
        String playlistName = PlaylistGenerator.buildPlaylistName(words);
        Playlist newPlaylist = new Playlist(playlistName);
        return this.strategy.generatePlaylistWeb(words, newPlaylist);
    }

    public void setStrategy(PlaylistGenerationStrategy strategy) {
        this.strategy = strategy;
    }
    // TODO: This is tyler typing... this method is dumb because we are just recombining
    // TODO: but I made this method for now
    // the words back together just to form the playlist name lmao????
    private static String buildPlaylistName(ArrayList<String> words){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++){
            sb.append(words.get(i));
            sb.append(" ");
        }
        return sb.toString();


    }
}
