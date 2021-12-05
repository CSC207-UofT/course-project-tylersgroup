package com.example.spottyv2.Controllers;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.User;
import com.example.spottyv2.UseCases.getUserPlaylist;

import java.util.ArrayList;

public class UserController {

    public ArrayList<Playlist> getPlaylists(User user){
        getUserPlaylist playlistGetter = new getUserPlaylist();
        return playlistGetter.getPlaylistList2(user);
    }
}
