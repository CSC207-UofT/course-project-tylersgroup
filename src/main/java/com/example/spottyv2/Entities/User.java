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

    @JsonProperty("playlist array")
    private List<Playlist> playlistList;
    //private List<User> friendsList;
    //private List<Song> blacklist;
    /**
     * Construct a User object, with the following parameters:
     * @param username Username of the User
     */
    public User(String username){
        this.username = username;
        this.playlistList = new ArrayList<>();
    }
    @JsonCreator
    public User(@JsonProperty("user-name") final String username,
                @JsonProperty("playlists") final List<Playlist> playlistList){
        this.username = username;
        this.playlistList = playlistList;
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
     * @param playlistList is the new list of playlists.
     */
    public void updatePlaylistList(List<Playlist> playlistList) {this.playlistList = playlistList;}


    //public List<User> getFriendsList() {return friendsList;
    //public List<Song> getBlacklist() {return blacklist;}
    //public void setFriendsList(){this.friendsList = new ArrayList<User>();}
    //public void setFriendsList(List<User> friendsList) {this.friendsList = friendsList;}
    //public void setBlacklist(){this.blacklist = new ArrayList<Song>();}
    //public void setBlacklist(List<Song> blacklist) {this.blacklist = blacklist;}

    /**
     * Override toString
     *
     * @return user as a string
     **/
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", playlistList=" + playlistList +
                '}';
    }

    /**
     * Serialize to a JSON formatted stream.
     *
     * @param writable where the resulting JSON text should be sent.
     * @throws IOException when the writable encounters an I/O error.
     */
    @Override
    public void toJson(Writer writable) throws IOException {
        try{
            writable.write(this.toJson());
        } catch (Exception ignored) {
        }
    }
}
