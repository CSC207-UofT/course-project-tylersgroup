package com.example.spottyv2.UseCases;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class getUserPlaylist {
    //Good method
    public ArrayList<String> getPlaylistList(User user){
        ArrayList<String> listOut = new ArrayList<>();
        List<Playlist> playlistList = user.getPlaylistList();

        for (Playlist playlist : playlistList){
            listOut.add(playlist.toString());

        }
        return listOut;
    }
    //bad method
    public ArrayList<Playlist> getPlaylistList2(User user){
        return (ArrayList<Playlist>) user.getPlaylistList();
    }
}
