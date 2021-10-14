package UseCases;

/*
 * A Use Case class
 *
 * PlaylistManager manages all the playlists created
 */


import Entities.User;
import Entities.Playlist;

import java.util.*;



public class PlaylistManager {
    private List<Playlist> playlists;

    public PlaylistManager(){
        playlists = new ArrayList<Playlist>();
    }

    public boolean addPlaylist(Playlist playlist, User user){
        return user.getPlaylistList().add(playlist);
    }

    public boolean removePlaylist(Playlist playlist, User user){ return user.getPlaylistList().remove(playlist);
    }
}
