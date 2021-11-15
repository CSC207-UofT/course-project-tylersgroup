package com.example.spottywebapp.UseCases;

import com.example.spottywebapp.Entities.Playlist;
import com.example.spottywebapp.Entities.Song;

import java.util.ArrayList;
import java.util.List;

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
//        for (String s : words) {
//            Song song = SongGenerator.generateSongSpotify(s); //create a song entity for that song
//            // receive the song entities and instantiate a playlist entity
//            newPlaylist.addSong(song);
//        }
        String s;
        for (int i=0; i < words.size(); i +=2) {
            if (words.size() - i == 3 ) {
                s = words.subList(i, words.size()).toString();
                Song song = SongGenerator.generateSongSpotify(s); //create a song entity for that song
                // receive the song entities and instantiate a playlist entity
                newPlaylist.addSong(song);
                return newPlaylist;
            } else {
                s = words.subList(i, i + 2).toString();
            }
            Song song = SongGenerator.generateSongSpotify(s); //create a song entity for that song
            // receive the song entities and instantiate a playlist entity
            newPlaylist.addSong(song);
        }
        return newPlaylist;
    }
}
