package com.example.spottyv2.Entities;

//import java.io.Serializable;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class User implements Jsonable {
    private final String userID;
    private final boolean isDefaultUser;

    private List<Playlist> playlistList;

    /**
     * Construct a User object, with the following parameter:
     * @param userID Username of the User
     * @param isDefaultUser is User a default user
     */
    public User(String userID, boolean isDefaultUser){
        this.userID = userID;
        this.isDefaultUser = isDefaultUser;
    }

    /**
     * Getter for username.
     * @return the username of this user.
     */
    public String getUserID() {return userID;}

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

    /**
     * Override toString
     * @return user as a string in the form of: This user *username* has *number of playlists* playlist(s).
     **/
    @Override
    public String toString(){return " userID: " + this.userID;}

    /**
     * Serialize to a JSON formatted string.
     *
     * @return a string, formatted in JSON, that represents the Jsonable.
     */
    @Override
    public String toJson() {
        JsonObject json = new JsonObject();
        json.put("userID", this.userID);
        json.put("isDefaultUser", this.isDefaultUser);
        json.put("playlist array", this.playlistList);
        return json.toJson();
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
