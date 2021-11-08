package com.example.spottywebapp.UseCases;
/*
 * PlaylistGenerator takes in the string of user input and generates a playlist of songs
 */


import com.example.spottywebapp.entities.Playlist;
import com.example.spottywebapp.entities.Song;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlaylistGenerator {
    public static Playlist generatePlaylist(ArrayList<String> words){
        String playlistName = buildPlaylistName(words);

        Playlist newPlaylist = new Playlist(playlistName);
        List<String> wordList = (List<String>) words;
//        for (String s : words) {
//            Song song = SongGenerator.generateSong(s); //create a song entity for that song
//            // receive the song entities and instantiate a playlist entity
//            newPlaylist.addSong(song);
//        }
        int s = 0;
        int e = words.size();
        while (s < words.size()) {
            // check if no song starts with the word at index s
            if (s == e) {
                // shift the starting index to after that song
                s = s + 1;
                // shift the end index to the very back to restart the search
                e = words.size();
            }
            else {
                String songName = String.join(" ", wordList.subList(s, e));
                // System.out.println(songName);
                // make request to song generator
                Song newSong = SongGenerator.generateSong(songName);
                // check if we got a song with that name
                if (!newSong.getName().equals("")) {
                    newPlaylist.addSong(newSong);
                    // System.out.println(newSong);
                    // shift the starting index to the end
                    s = e;
                    // shift back the ending index.
                    e = words.size();
                } else {
                    // when we didn't find a song that starts with S and ends with E,
                    // we decrement the end index by 1.
                    e = e - 1;
                }
            }
        }
        return newPlaylist;
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
