package com.example.spottywebapp.UseCases;

import com.example.spottywebapp.Entities.Playlist;
import com.example.spottywebapp.Entities.Song;

import java.util.ArrayList;
import java.util.List;

public class LongestPlaylistGenerator implements PlaylistGenerationStrategy{
    public Playlist generatePlaylist(ArrayList<String> words, Playlist newPlaylist){
        for (String s : words) {
            Song song = SongGenerator.generateSongSpotify(s); //create a song entity for that song
            // receive the song entities and instantiate a playlist entity
            newPlaylist.addSong(song);
        }
        return newPlaylist;
    }
}
