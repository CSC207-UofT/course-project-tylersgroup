package com.example.spottyv2.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Playlist {


    private List<Song> playlist;

    private String playlistName;
    private List<String> songUris;
    private String stringSongUri;


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
        this.stringSongUri = songURIs.toString();
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

    public void setSongUris(String[] songUris){
        this.songUris = List.of(songUris);
    }

    public String getStringSongUri(){
        return stringSongUri;
    }

    public void setStringSongUri(String uri){
        this.stringSongUri = uri;
    }


    /**
     * Adds song into end of playlist, also adds songUri to playlist.
     */
    public void addSong(Song song){
        playlist.add(song);
        this.songUris.add(song.getSongUri());
        this.stringSongUri = this.songUris.toString();
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
}