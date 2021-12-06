package com.example.spottyv2.api.web;

import com.example.spottyv2.Entities.Playlist;

import java.util.ArrayList;

public class ManagerContainer {
    private String ID;
    private String name;
    private String playlistURIs;

    public ManagerContainer(){

    }
    public ManagerContainer(String ID, String name, String playlistURIs){
        this.ID = ID;
        this.name = name;
        this.playlistURIs = playlistURIs;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getPlaylistURIs() {return this.playlistURIs;
    }

    public void setPlaylistURIs(String playlistURIs){
        this.playlistURIs = playlistURIs;
    }
}
