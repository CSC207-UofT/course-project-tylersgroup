package Entities;

import java.util.*;

public class Playlist{
    private List<Song> playlist;
    private String playlistName;

    /**
     * Construct a Playlist object, with the following parameters:
     *
     * @param playlistName Name of the playlist, may be unnamed
     *
     */
    //constructor
    Playlist(){
        this.playlist = new ArrayList<Song>();
        this.playlistName = "Unnamed Playlist";
    }

    Playlist(String name){
        this.playlist = new ArrayList<Song>();
        this.playlistName = name;
    }

    public Song getSongAtIndex(int i){
        if(i < this.getPlaylistLength()){
            playlist.get(i);
        }
    }

    public String getPlaylistName(){
        return playlistName;
    }

    public String setPlaylistName(String newName){
        //change playlist name and return a string with the new name
        String oldName = this.getPlaylistName();
        this.playlistName = newName;
        return "Playlist " + oldName + " was renamed to: " + newName;
    }

    public int getPlaylistLength(){
        // return length of playlist in terms of how many songs are in it
        return playlist.size();
    }

    @Override
    public int compareTo(Playlist other){
        //compare playlists by lengths? Maybe later we can do some funky compareTo with like how "popular" it is
        if(this.getPlaylistLength() > other.getPlaylistLength()){
            return 1;
        }
        else if(this.getPlaylistLength() < other.getPlaylistLength()){
            return -1;
        }
        else{
            //equal lengths
            return 0;
        }
    }

    @Override
    public String toString(){
        //return string representation of playlist, just print string reps of songs in order
        String s = "";
        for(int i=0; i<this.getPlaylistLength(); i++){
            s = i + ") " + this.getSongAtIndex(i).toString() + "\n";
        }
        return s;
    }
}