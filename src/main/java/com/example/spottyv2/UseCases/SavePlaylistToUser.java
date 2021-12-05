package com.example.spottyv2.UseCases;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.User;

public class SavePlaylistToUser {

    public boolean savePlaylistToUser(User user, Playlist playlist){
        for (Playlist userPlaylist : user.getPlaylistList()){
            if (userPlaylist.equals(playlist)){
                return false;
            }
        }
        user.addPlaylist(playlist);
        return true;
    }
}
