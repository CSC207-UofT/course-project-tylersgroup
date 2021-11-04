package com.example.spottywebapp.UseCases;

/*
 * A Use Case class
 *
 * PlaylistManager manages all the playlists created
 */



import com.example.spottywebapp.entities.Playlist;
import com.example.spottywebapp.entities.User;

import java.util.List;


public class PlaylistManager {
    // Making PlaylistManager a singleton
    private static PlaylistManager PLAYLISTMANAGER = null;

    public static PlaylistManager getInstance(){
        if (PLAYLISTMANAGER == null){
            PLAYLISTMANAGER = new PlaylistManager();
        }
        return PLAYLISTMANAGER;
    }

    public static User getUser(String username){
        UserManager USERMANAGER = UserManager.getInstance();
        User currentUser = USERMANAGER.getUser(username);
        return currentUser;
    }

    public boolean addPlaylist(Playlist playlist, String username){
        User user = getUser(username);
        return user.getPlaylistList().add(playlist);
    }

    public boolean removePlaylist(Playlist playlist, String username){
        User user = getUser(username);
        return user.getPlaylistList().remove(playlist);
    }

    public static boolean removePlaylist(int playlistIndex, String username){
        User user = getUser(username);
        List<Playlist> userPlaylist = user.getPlaylistList();
        Playlist removedPlaylist = userPlaylist.remove(playlistIndex);
        return removedPlaylist != null;
    }

    public static void renamePlaylist(int playlistIndex, String username, String newName) {
        User user = getUser(username);
        List<Playlist> userPlaylist = user.getPlaylistList();
        Playlist wantedPlaylist = userPlaylist.get(playlistIndex);
        wantedPlaylist.setPlaylistName(newName);
    }

    public static void printUserPlaylist(String username){
        User user = getUser(username);
        List<Playlist> playlistlist = user.getPlaylistList();
        for (int i = 0; i < playlistlist.size(); i++) {
            // Index start at 0 but we want the list to start from 1
            System.out.print(i + 1);
            System.out.print(": ");
            System.out.println(playlistlist.get(i).getPlaylistName());
        }
    }
}
