package com.example.spottyv2.Entities;

//import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class User {

    private final String username;
    private final boolean isDefaultUser;

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
        return "User{" +
                "username='" + username + '\'' +
                ", playlistList=" + playlistList +
                '}';
    }

}
