package com.example.spottyv2.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private final String username;
    private boolean isDefaultUser;

    private List<Playlist> playlistList;
    //private List<User> friendsList;
    //private List<Song> blacklist;
    /**
     * Construct a User object, with the following parameters:
     * @param username Username of the User
     */
    public User(String username, boolean isDefaultUser){
        this.isDefaultUser = isDefaultUser;
        this.username = username;
        this.playlistList = new ArrayList<>();
    }

    public User(){
        this.username = "";
        this.isDefaultUser = false;
        this.playlistList = new ArrayList<>();
    }

    /**
     * Getter for username.
     * @return the username of this user.
     */
    public String getUsername() {return username;}

    /**
     * Getter for a list of playlists.
     * @return the list of playlists this user has.
     */
    public List<Playlist> getPlaylistList() {return playlistList;}

    /**
     * Updates the list of playlists this user has.
     * @param playlist is the new playlist to be added to the user's playlists.
     */
    public void addPlaylist(Playlist playlist) {this.playlistList.add(playlist);}


    //public List<User> getFriendsList() {return friendsList;
    //public List<Song> getBlacklist() {return blacklist;}
    //public void setFriendsList(){this.friendsList = new ArrayList<User>();}
    //public void setFriendsList(List<User> friendsList) {this.friendsList = friendsList;}
    //public void setBlacklist(){this.blacklist = new ArrayList<Song>();}
    //public void setBlacklist(List<Song> blacklist) {this.blacklist = blacklist;}

    /**
     * Override toString
     * @return user as a string
     **/
    @Override
    public String toString() {
        return this.username + " has " + this.playlistList.size() + " playlists saved.";
    }

    public boolean getDefaultUser() {return this.isDefaultUser;
    }

    public void setDefaultUser(boolean isDefaultUser){
        this.isDefaultUser = isDefaultUser;
    }

}
