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
        // check if even
        System.out.println(words);
        if (words.size() % 2 == 0 ) {
            System.out.println("=====even=====");
            for (int i = 0; i < words.size()-1; i += 2) {
                String s = "";
                for (int j = i; j < i + 2; j++ ){
                    s = s + words.get(j) + " ";
                }
                System.out.println("=====");
                System.out.println(s);
                System.out.println("======");
                Song song = SongGenerator.generateSongSpotify(s.trim()); //create a song entity for that song
                // receive the song entities and instantiate a playlist entity
                newPlaylist.addSong(song);
            }
        } else {
            // if odd
            System.out.println("odd");
            String s = "";
            for (int j = 0; j < 3; j++ ){
                s = s + words.get(j) + " ";
            }
            Song song = SongGenerator.generateSongSpotify(s.trim());
            newPlaylist.addSong(song);
            for (int i = 3; i < words.size()-1; i += 2) {
                s = "";
                for (int j = i; j < i + 2; j++ ){
                    s = s + words.get(j) + " ";
                }
                System.out.println("=====");
                System.out.println(s);
                System.out.println("======");
                song = SongGenerator.generateSongSpotify(s.trim()); //create a song entity for that song
                // receive the song entities and instantiate a playlist entity
                newPlaylist.addSong(song);
            }
        }


//         String s;
//         for (int i=0; i < words.size(); i +=2) {
//             if (words.size() - i == 3 ) {
//                 s = words.subList(i, words.size()).toString();
//                 Song song = SongGenerator.generateSongSpotify(s); //create a song entity for that song
//                 // receive the song entities and instantiate a playlist entity
//                 newPlaylist.addSong(song);
//                 return newPlaylist;
//             } else {
//                 s = words.subList(i, i + 2).toString();
//             }
//             Song song = SongGenerator.generateSongSpotify(s); //create a song entity for that song
//             // receive the song entities and instantiate a playlist entity
//             newPlaylist.addSong(song);
//         }
        return newPlaylist;
    }
}
