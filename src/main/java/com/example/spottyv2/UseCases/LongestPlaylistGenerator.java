package com.example.spottyv2.UseCases;


import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.Song;

import java.util.ArrayList;

public class LongestPlaylistGenerator implements PlaylistGenerationStrategy{
    public Playlist generatePlaylist(ArrayList<String> words, Playlist newPlaylist){
        for (String s : words) {
            Song song = SongGenerator.generateSong(s); //create a song entity for that song
            // receive the song entities and instantiate a playlist entity
            newPlaylist.addSong(song);
        }
        return newPlaylist;
    }

    public Playlist generatePlaylistWeb(ArrayList<String> words, Playlist newPlaylist){
        int start = 0;
        // check if odd length
        if (words.size() % 2 == 1 ) {
            start = 3;
            // if odd
            System.out.println("odd");
            String s = "";
            for (int j = 0; j < 3; j++ ){
                s = s + words.get(j) + " ";
            }
            Song firstSong = SongGenerator.generateSongSpotify(s.trim());
            newPlaylist.addSong(firstSong);
        }
        for (int i = start; i < words.size()-1; i += 2) {
            String s = "";
            for (int j = i; j < i + 2; j++ ){
                s = s + words.get(j) + " ";
            }

            Song song = SongGenerator.generateSongSpotify(s.trim()); //create a song entity for that song
            // receive the song entities and instantiate a playlist entity
            newPlaylist.addSong(song);
        }

        return newPlaylist;
    }
}
