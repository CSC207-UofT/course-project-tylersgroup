package UseCases;/*
 * A Use Case class
 *
 * PlaylistManager manages all the playlists created
 */


import java.util.*;



public class PlaylistManager {
    private List<Playlist> playlists;

    public PlaylistManager(){
        playlists = new ArrayList<Playlist>();
    }

    public void checkOrder(Playlist playlist){
        // Iterate through the songs in order and see if it matches the input string ??
    }
}
