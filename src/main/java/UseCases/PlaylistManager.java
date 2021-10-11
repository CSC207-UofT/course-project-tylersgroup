package UseCases;/*
 * A Use Case class
 *
 * PlaylistManager manages all the playlists created
 */


import Entities.User;

import java.util.*;



public class PlaylistManager {
    private List<Playlist> playlists;

    public PlaylistManager(){
        playlists = new ArrayList<Playlist>();
    }

    public void checkOrder(Playlist playlist){
        // Iterate through the songs in order and see if it matches the input string ??
    }

    //
    public void addPlaylist(Playlist playlist, User user){
        user.getPlaylistList().add(playlist);
    }

    //TODO: not sure why I am getting the error here .remove(playlist)
    public void removePlaylist(Playlist playlist, User user){
        user.getPlaylistList().remove(playlist);
    }
}
