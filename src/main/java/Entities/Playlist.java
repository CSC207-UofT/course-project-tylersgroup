package Entities;

import java.util.*;

public class Playlist{
    private List<Song> playlist;
    private String playlistName;

    /**
     * Construct a Playlist object with no name given
     */
    public Playlist(){
        this.playlist = new ArrayList<>();
        this.playlistName = "Unnamed Playlist";
    }

    // constructor for playlist with name

    /**
     * Construct a Playlist object with the given name
     * @param name is the name of the playlist
     */
    public Playlist(String name){
        this.playlist = new ArrayList<>();
        this.playlistName = name;
    }

    /**
     * Get a song at the specified index of the playlist.
     * @param i is the index
     * @return the Song at index, null if out of bounds
     */
    public Song getSongAtIndex(int i){
        if(i < this.getPlaylistLength()){
            return playlist.get(i);
        } else {
            return null;
        }
    }

    /**
     * Getter for playlist name
     * @return the playlist name
     */
    public String getPlaylistName(){
        return playlistName;
    }

    /**
     * Changes the playlist name to the provided name.
     * @param newName is the new name that will replace the old name.
     * @return a statement containing the old name and the new changed name.
     */
    public String setPlaylistName(String newName){
        //change playlist name and return a string with the new name
        String oldName = this.getPlaylistName();
        this.playlistName = newName;
        return "Playlist " + oldName + " was renamed to: " + newName;
    }

    /**
     * Getter for playlist length
     * @return the playlist length
     */
    public int getPlaylistLength(){
        // return length of playlist in terms of how many songs are in it
        return playlist.size();
    }

    /**
     * Adds song into end of playlist
     * @return boolean true if song was successfully added into playlist
     */
    public boolean addSong(Song song){
        return playlist.add(song);
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
     * @return the string representation of Playlist
     */
    @Override
    public String toString(){
        //return string representation of playlist, just print string reps of songs in order
        StringBuilder s = new StringBuilder();
        for(int i=0; i<this.getPlaylistLength(); i++){
            s.append(i).append(") ").append(this.getSongAtIndex(i).toString()).append("\n");
        }
        return s.toString();
    }
}