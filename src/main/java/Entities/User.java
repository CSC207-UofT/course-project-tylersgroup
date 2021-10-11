package Entities;//getPlaylists()
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
    private List<User> friendsList;
    private List<Song> blacklist;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public List<Playlist> getPlaylistList() {return playlistList;}

    public List<User> getFriendsList() {return friendsList;}

    public List<Song> getBlacklist() {return blacklist;}

    public void setPlaylistList(){this.playlistList = new ArrayList<Playlist>();}

    public void setPlaylistList(List<Playlist> playlistList) {this.playlistList = playlistList;}

    public void setFriendsList(){this.friendsList = new ArrayList<User>();}

    public void setFriendsList(List<User> friendsList) {this.friendsList = friendsList;}

    public void setBlacklist(){this.blacklist = new ArrayList<Song>();}

    public void setBlacklist(List<Song> blacklist) {this.blacklist = blacklist;}

}
