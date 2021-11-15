
package com.example.spottywebapp.UseCases;

import com.example.spottywebapp.Entities.Song;
import com.example.spottywebapp.api.spotifyApi.SpotifyApiSongController;
import com.wrapper.spotify.model_objects.specification.Track;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class SongGenerator {

    public SongGenerator(){
    }

    /**
     * reads off CSV and returns the artist name
     * @param songName song name
     * @return artist name as String. When no song has been found, return "" as artist name.
     */
    public static String CSVReader(String songName){

        String path = "sample_data.csv"; // csvFile name goes here
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (songName.equals(data[0])) {
                    return data[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // when no song has been found, return "" as artist name
        return "";
    }
    /**
     * create and return a new Song whose name matches with the parameter, using CSVReader method.
     * @param songName song name
     * @return a newly created Song object whose name matches with songName.
     *          When no song has been found, return an empty song.
     */
    public static Song generateSong(String songName){
        String artist = SongGenerator.CSVReader(songName);
        if (!Objects.equals(artist, "")){
            return new Song(songName, artist);
        }
        return new Song();
    }

    public static Song generateSongSpotify(String songName){
        Track temp_song = SpotifyApiSongController.searchSong(songName);
        if(temp_song != null){
            return new Song(temp_song.getName(),
                    temp_song.getArtists()[0].getName(),
                    temp_song.getDurationMs(),
                    temp_song.getAlbum().getName(),
                    temp_song.getIsExplicit(),
                    temp_song.getPopularity());
        }
        return new Song();
    }

}

