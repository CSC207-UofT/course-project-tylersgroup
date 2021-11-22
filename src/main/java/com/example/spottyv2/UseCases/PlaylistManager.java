package com.example.spottyv2.UseCases;


/*
 * A Use Case class
 *
 * PlaylistManager manages all the playlists created
 */



import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.User;

import java.util.List;

/**
 * A Use Case class
 *
 * PlaylistManager manages all the playlists created.
 */
public class PlaylistManager {
    // Making PlaylistManager a singleton
    private static PlaylistManager PLAYLISTMANAGER = null;

    /**
     * Instantiate the singleton PlaylistManager.
     * @return the PlaylistManager singleton
     */
    public static PlaylistManager getInstance(){
        if (PLAYLISTMANAGER == null){
            PLAYLISTMANAGER = new PlaylistManager();
        }
        return PLAYLISTMANAGER;
    }

    /**
     * Gets the User which the PlaylistManager should be changing
     * This method is called for every method call below.
     * This method should be called once in the constructor, because we manage
     * more than one user.
     * @param username username of wanted user
     * @return a User entity
     */
    public static User getUser(String username){
        UserManager USERMANAGER = UserManager.getInstance();
        return USERMANAGER.getUser(username);
    }

    /**
     * Adds a playlist to a user.
     * The playlist is a Playlist object.
     * The user is specified by the username.
     * @param playlist a Playlist object
     * @param username username of user
     * @return whether adding the playlist to the user is successful.
     */
    public boolean addPlaylist(Playlist playlist, String username){
        User user = getUser(username);
        return user.getPlaylistList().add(playlist);
    }

    /**
     * Removes a playlist from a user
     * @param playlist a Playlist object
     * @param username username of user
     * @return whether removing the playlist from the user is successful
     */
    public boolean removePlaylist(Playlist playlist, String username){
        User user = getUser(username);
        return user.getPlaylistList().remove(playlist);
    }

    /**
     * Removes a playlist from a user using the index of the list of playlist of the user.
     * @param playlistIndex the index of the playlist from the playlists of the user
     * @param username username of user
     * @return whether removing a selected playlist from the list of playlist of the user
     * is successful
     */
    public static boolean removePlaylist(int playlistIndex, String username){
        User user = getUser(username);
        List<Playlist> userPlaylist = user.getPlaylistList();
        Playlist removedPlaylist = userPlaylist.remove(playlistIndex);
        return removedPlaylist != null;
    }

    /**
     * Renames a playlist of the list of playlists of the user.
     * @param playlistIndex the index of the playlist from the playlists of the user
     * @param username username of user
     * @param newName the new name of the playlist
     */
    public static void renamePlaylist(int playlistIndex, String username, String newName) {
        User user = getUser(username);
        List<Playlist> userPlaylist = user.getPlaylistList();
        Playlist wantedPlaylist = userPlaylist.get(playlistIndex);
        wantedPlaylist.setPlaylistName(newName);
    }

    /**
     * Prints all the user's playlists.
     * @param username username of user
     */
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
