package com.example.spottywebapp.UseCases;

/*
 * A Use Case class
 *
 * PlaylistManager manages all the playlists created
 */


import com.example.spottywebapp.entities.Playlist;
import com.example.spottywebapp.entities.User;

public class PlaylistManager {

    public PlaylistManager(){}

    public boolean addPlaylist(Playlist playlist, User user){
        return user.getPlaylistList().add(playlist);
    }

    public boolean removePlaylist(Playlist playlist, User user){ return user.getPlaylistList().remove(playlist);
    }
}
