package UseCases;

/*
 * A Use Case class
 *
 * PlaylistManager manages all the playlists created
 */


import Entities.Playlist;
import Entities.User;

import java.util.List;


public class PlaylistManager {

    public PlaylistManager(){}

    public boolean addPlaylist(Playlist playlist, User user){
        return user.getPlaylistList().add(playlist);
    }

    public boolean removePlaylist(Playlist playlist, User user){ return user.getPlaylistList().remove(playlist); }

    public static boolean removePlaylist(int playlistIndex, User user){
        List<Playlist> userPlaylist = user.getPlaylistList();
        Playlist removedPlaylist = userPlaylist.remove(playlistIndex);
        return removedPlaylist != null;
    }

    public static void renamePlaylist(int playlistIndex, User user, String newName) {
        List<Playlist> userPlaylist = user.getPlaylistList();
        Playlist wantedPlaylist = userPlaylist.get(playlistIndex);
        wantedPlaylist.setPlaylistName(newName);
    }
}
