package Entities;
import java.util.*;

public class Song {
    private String name;
    private String artist;
    private int duration;
    private String album;
    private String genre;
    private boolean explicit;
    private int popularity;

    /**
     * Construct a Song object, with the following parameters:
     *
     * @param name Name of the song
     * @param artist Artist name
     * @param duration How long the song is in seconds
     * @param album Name of the album, might be a single
     * @param genre Genre of song
     * @param explicit Boolean representing whether the song is family friendly or not
     * @param popularity Int representing spot in charts
     **/

    /**
     * Constructs a song which has an associated album.
     */
    public Song(String name, String artist, int duration, String album, String genre, boolean explicit, int popularity) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.album = album;
        this.genre = genre;
        this.explicit = explicit;
        this.popularity = popularity;
    }

    /**
     * Constructs a song that is a single (no associated album)
     */
    public Song(String name, String artist, int duration, String genre, boolean explicit, int popularity) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.album = name;
        this.genre = genre;
        this.explicit = explicit;
        this.popularity = popularity;
    }

//    /**
//     * Constructs a song with just name and artist
//     **/
//    public Song(String name, String artist){
//        this.name = name;
//        this.artist = artist;
//        this.duration = 0;
//        this.album = "";
//        this.genre = "";
//        this.explicit = false;
//        this.popularity = 0;
//    }

    /**
     * Temporary song constructor only for name and artist for phase 0
     *
     */
    public Song(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.duration = -1;
        this.album = "sample album";
        this.genre = "sample genre";
        this.explicit = false;
        this.popularity = -1;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getArtist() {
        // retruns artist name
        return artist;
    }

    public String getAlbum() {
        //returns album from where the song is from
        return album;
    }

    public String getGenre() {
        //returns genre of album
        return genre;
    }

    public boolean isExplicit() {
        //returns True if song is explicit
        return explicit;
    }

    public double getPopularity() {
        //returns ranking on charts
        return popularity;
    }

    /**
     * Override toString
     * return song as a string in the form of: *Name*, *album name*, by *artist name*.
     **/
    @Override
    public String toString() {
        return name + ", " + album + ", by: " + artist + ".";
    }
}