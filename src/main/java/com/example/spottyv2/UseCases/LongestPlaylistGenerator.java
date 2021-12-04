package com.example.spottyv2.UseCases;


import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.Song;

import java.util.ArrayList;

public class LongestPlaylistGenerator implements PlaylistGenerationStrategy{
    /**
     * Generates a playlist given a String ArrayList of words. For every element in words, if the song is found then
     * a new spottywebapp song entity is created representing that song, and is added to the new playlist.
     * @param words ArrayList of Strings representing the user's input.
     * @param newPlaylist new playlist obj
     * @return Spotty Playlist object representation nof the user's input.
     */
    public Playlist generatePlaylist(ArrayList<String> words, Playlist newPlaylist){
        for (String s : words) {
            Song song = SongGenerator.generateSong(s);
            newPlaylist.addSong(song);
        }
        return newPlaylist;
    }


    /**
     * Generates a playlist given a String ArrayList of words. For every element in words, if the song is found then
     * a new spotify track object is created representing that song, and is added to the new playlist.
     * @param words ArrayList of Strings representing the user's input.
     * @param newPlaylist new playlist obj
     * @return Spotty Playlist object representation nof the user's input. Don't want to create a spotify playlist object
     * as it's not necessarily true that the user is going to want to add that playlist to their spotify library.
     */
    public Playlist generatePlaylistWeb(ArrayList<String> words, Playlist newPlaylist){
       for (String s : words) {
           Song song = SongGenerator.generateSongSpotify(s); //create a song entity for that song
           // receive the song entities and instantiate a playlist entity
           newPlaylist.addSong(song);
       }
        return newPlaylist;
    }
}
