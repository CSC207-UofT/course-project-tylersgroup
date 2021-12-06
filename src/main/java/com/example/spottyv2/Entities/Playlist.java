package com.example.spottyv2.Entities;

import java.io.Serializable; //remove?

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Playlist {


    private List<Song> playlist;

    private String playlistName;
    private List<String> songUris;


    /**
     * Construct a Playlist object with no name given
     */
    public Playlist() {
        this.playlist = new ArrayList<>();
        this.playlistName = "Unnamed Playlist";
        this.songUris = new ArrayList<>();
    }


    /**
     * Construct a Playlist object with the given name
     *
     * @param name is the name of the playlist
     */
    public Playlist(String name) {
        this.playlist = new ArrayList<>();
        this.playlistName = name;
        this.songUris = new ArrayList<>();
    }

    public Playlist(String name, ArrayList<String> songURIs) {
        this.playlist = new ArrayList<>();
        this.playlistName = name;
        this.songUris = songURIs;
    }

    /**
     * Get a song at the specified index of the playlist.
     *
     * @param i is the index
     * @return the Song at index, null if out of bounds
     */
    public Song getSongAtIndex(int i) {
        if (i < this.getPlaylistLength()) {
            return playlist.get(i);
        } else {
            return null;
        }
    }

    /**
     * Getter for playlist name
     *
     * @return the playlist name
     */
    public String getPlaylistName() {
        return playlistName;
    }

    /**
     * Changes the playlist name to the provided name.
     *
     * @param newName is the new name that will replace the old name.
     * @return a statement containing the old name and the new changed name.
     */
    public String setPlaylistName(String newName) {
        String oldName = this.getPlaylistName();
        this.playlistName = newName;
        return "Playlist " + oldName + " was renamed to: " + newName;
    }

    /**
     * Getter for playlist length
     *
     * @return the playlist length
     */
    public int getPlaylistLength() {
        return playlist.size();
    }

    /**
     * Get an array representation of all the song uris contained within the playlist.
     * @return String array with the uris.
     */
    public String[] getSongUriArray(){
        String[] uriArray = new String[songUris.size()];
        uriArray = songUris.toArray(uriArray);
        return uriArray;
    }

    public String getStringSongUri(){
        return this.songUris.toString();
    }


    /**
     * Adds song into end of playlist, also adds songUri to playlist.
     */
    public void addSong(Song song){
        playlist.add(song);
        this.songUris.add(song.getSongUri());
        System.out.println(song.getName() + "was added to the playlist.");
    }
    /**
     * Getter method for list of songs.
     */
    public List<Song> getPlaylist() {
        return playlist;
    }

    //TODO: Override should implement Comparable. Uncomment this method for now
//    @Override
//    public int compareTo(Playlist other){
//        //compare playlists by lengths? Maybe later we can do some funky compareTo with like how "popular" it is
//        if(this.getPlaylistLength() > other.getPlaylistLength()){
//            return 1;
//        }
//        else if(this.getPlaylistLength() < other.getPlaylistLength()){
//            return -1;
//        }
//        else{
//            //equal lengths
//            return 0;
//        }
//    }

    /**
     * toString for Playlist class
     *
     * @return the string representation of Playlist
     */
    @Override
    public String toString() {
        //return string representation of playlist, just print string reps of songs in order
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.getPlaylistLength(); i++) {
            s.append(i).append(") ").append(this.getSongAtIndex(i).toString()).append("\n");
        }
        return s.toString();
    }

//    @SuppressWarnings("unchecked")
//    @JsonProperty("playlist")
//    private void unpackNested(Map<String,List> songs) {
//        this.playlist = (List<Song>) songs.get("playlist");
//    }

//
//    @Override
//    public String toJson() {
//        JsonObject json = new JsonObject();
//        json.put("name", this.playlistName);
//        json.put("playlist array", this.playlist);
//        //should we add length, etc. ?
//        return json.toJson();
//    }
    /**
     * toJson to be used in serializing Playlist class
     * @return the Json string of Playlist
     */

//    @JsonValue
//    public String toJson(){
//        return "{" +
//                "playlistName='" + this.playlistName + '\'' +
//                ", songs="+ songUris +
//                '}';
//    }
}