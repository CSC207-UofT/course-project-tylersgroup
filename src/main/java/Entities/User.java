package Entities;
//getPlaylists()
//getUsername()
//getPassword()
//getFriendsList()
//getSongBlacklist()
//addPlaylist(Playlist)
//removePlaylist(Playlist)

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

    // constructor
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.playlistList = new ArrayList<>();
    }

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public List<Playlist> getPlaylistList() {return playlistList;}

    public void updatePlaylistList(List<Playlist> playlistList) {this.playlistList = playlistList;}


    //public List<User> getFriendsList() {return friendsList;
    //public List<Song> getBlacklist() {return blacklist;}
    //public void setFriendsList(){this.friendsList = new ArrayList<User>();}
    //public void setFriendsList(List<User> friendsList) {this.friendsList = friendsList;}
    //public void setBlacklist(){this.blacklist = new ArrayList<Song>();}
    //public void setBlacklist(List<Song> blacklist) {this.blacklist = blacklist;}

    @Override
    public String toString(){
        //return string representation of the user containing its username and the number of playlists it contains
        return "This user " + this.username + " has " + this.playlistList.size() + " playlist(s).";
    }
}
