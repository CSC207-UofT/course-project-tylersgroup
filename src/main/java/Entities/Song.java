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
     */

    //Song within an album

    /**
     * Constructs a song which has an associated album.
     */
<<<<<<< HEAD
    public Song(String name, String artist, int duration, String album, String genre, boolean explicit, int popularity) {
=======

    Song(String name, String artist, int duration, String album, String genre, boolean explicit, int popularity) {
>>>>>>> f94e1d0f68ce935c7ade07e95b6e9f7d95c33f20
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
    Song(String name, String artist, int duration, String genre, boolean explicit, int popularity) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.album = name;
        this.genre = genre;
        this.explicit = explicit;
        this.popularity = popularity;
    }
    /**
     * Constructs a song with just name and artist
     */
    public Song(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.duration = 0;
        this.album = "";
        this.genre = "";
        this.explicit = false;
        this.popularity = 0;
    }

    /**
     * Temporary song constructor only for name and artist for phase 0
     *
     */
    Song(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.duration = -1;
        this.album = "temp";
        this.genre = "temp";
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
     * @Override toString
     * return song as a string in the form of: *Name*, *album name*, by *artist name*.
     **/
    public String toString() {
        return name + ", " + album + ", by: " + artist + ".";
    }
}