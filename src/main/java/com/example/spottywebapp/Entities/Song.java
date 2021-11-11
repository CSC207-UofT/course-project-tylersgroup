package com.example.spottywebapp.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Song {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private final String name;
    private final String artist;
    private final int duration;
    private final String album;
    private final String genre;
    private final boolean explicit;
    private final int popularity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    /**
     * construct an empty song
     */
    public Song() {
        this.name = "";
        this.artist = "";
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
        // returns artist name
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
        if (Objects.equals(this.name, "")) {
            return "<song not found>";
        } else {
            return name + ", " + album + ", by: " + artist + ".";
        }
    }
}

