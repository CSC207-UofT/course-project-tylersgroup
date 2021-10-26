package Entities;

import java.util.List;
import java.util.ArrayList;

public class User {
    private final String username;
    private final String password;
    private List<Playlist> playlistList;
    //private List<User> friendsList;
    //private List<Song> blacklist;
    /**
     * Construct a User object, with the following parameters:
     * @param username Username of the User
     * @param password Password of the User
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.playlistList = new ArrayList<>();
    }

    /**
     * Getter for username.
     * @return the username of this user.
     */
    public String getUsername() {return username;}

    /**
     * Getter for password.
     * @return the password of this user.
     */
    public String getPassword() {return password;}

    /**
     * Getter for a list of playlists.
     * @return the list of playlists this user has.
     */
    public List<Playlist> getPlaylistList() {return playlistList;}

    /**
     * Return whether the password parameter matches this user's password.
     * @param password the password guess
     * @return whether the guess matches the real password.
     */
    public boolean passwordMatches(String password){
        return this.password.equals(password);
    }

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
     * @return user as a string in the form of: This user *username* has *number of playlists* playlist(s).
     **/
    @Override
    public String toString(){
        return "This user " + this.username + " has " + this.playlistList.size() + " playlist(s).";
    }

}
