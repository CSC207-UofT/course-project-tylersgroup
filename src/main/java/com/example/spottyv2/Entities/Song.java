package com.example.spottyv2.Entities;


import java.io.Serializable;
import java.util.Objects;

public class Song implements Serializable {

    private Long id;

    private final String name, artist, album, songUri;
    private final int duration, popularity;
    private final boolean explicit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Construct a Song object, with the following parameters:
     *
     * I want to be able to create a song object from a track object that we can use locally in java
     *
     * @param name Name of the song
     * @param artist Artist name
     * @param duration How long the song is in seconds
     * @param album Name of the album, might be a single
     * @param explicit Boolean representing whether the song is family friendly or not
     * @param popularity Int representing spot in charts
     * @param songUri String containing songUri;
     */
    public Song(String name, String artist, int duration, String album, String genre, boolean explicit, int popularity,
                String songUri) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.album = album;
        this.explicit = explicit;
        this.popularity = popularity;
        this.songUri = songUri;
    }

    /**
     * Constructs a song that is a single (no associated album)
     */
    public Song(String name, String artist, int duration, String genre, boolean explicit, int popularity, String songUri) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
        this.album = name;
        this.explicit = explicit;
        this.popularity = popularity;
        this.songUri = songUri;
    }

    /**
     * Temporary song constructor only for name and artist for phase 0
     *
     */
    public Song(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.duration = -1;
        this.album = "sample album";
        this.explicit = false;
        this.popularity = -1;
        this.songUri = "";
    }

    /**
     * construct an empty song
     */
    public Song() {
        this.name = "";
        this.artist = "";
        this.duration = -1;
        this.album = "sample album";
        this.explicit = false;
        this.popularity = -1;
        this.songUri = "";
    }

    /**
     * Get the Name of the song object
     * @return Song name as a string
     */
    public String getName() {
        return name;
    }

    public String getSongUri(){
        return songUri;
    }

    /**
     * Get the duration of the song
     * @return duration in seconds as an int.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Get the artist for the current song
     * @return artist name as a string.
     */
    public String getArtist() {return artist;}

    /**
     * Get the album from which the current song comes from
     * @return album name as a string
     */
    public String getAlbum() {return album;}

    /**
     * Get whether the album is explicit or not
     * @return True if album is explicit, false if not.
     */
    public boolean isExplicit() {
        return explicit;
    }

    /**
     * Get the popularity of the current song on the charts.
     * @return popularity of the song as a double
     */
    public double getPopularity() { return popularity;}

    /**
     * Override toString
     * return song as a string in the form of: *Name*, *album name*, by *artist name*.
     **/
    @Override
    public String toString() {
        if (Objects.equals(this.name, "")) {
            return "<song not found>";
        } else {
            return name + ", " + album + ", by: " + artist + ".";
        }
    }
}

