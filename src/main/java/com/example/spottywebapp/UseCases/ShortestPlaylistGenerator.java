package com.example.spottywebapp.UseCases;

import com.example.spottywebapp.Entities.Playlist;
import com.example.spottywebapp.Entities.Song;

import java.util.ArrayList;
import java.util.List;

public class ShortestPlaylistGenerator implements PlaylistGenerationStrategy{

    public Playlist generatePlaylist(ArrayList<String> words, Playlist newPlaylist){
        List<String> wordList = (List<String>) words;
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
                // make request to song generator
                Song newSong = SongGenerator.generateSong(songName);
                // check if we got a song with that name
                if (!newSong.getName().equals("")) {
                    newPlaylist.addSong(newSong);
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

    public Playlist generatePlaylistWeb(ArrayList<String> words, Playlist newPlaylist){
        List<String> wordList = (List<String>) words;
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
                // make request to song generator
                Song newSong = SongGenerator.generateSongSpotify(songName);
                // check if we got a song with that name
                if (!newSong.getName().equals("")) {
                    newPlaylist.addSong(newSong);
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
}
