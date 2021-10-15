package UseCases;

/*
 * A Use Case class
 *
 * PlaylistManager manages all the playlists created
 */


import Entities.Playlist;
import Entities.User;



public class PlaylistManager {

    public PlaylistManager(){}

    public static boolean addPlaylist(Playlist playlist, User user){
        return user.getPlaylistList().add(playlist);
    }

    public static boolean removePlaylist(Playlist playlist, User user){ return user.getPlaylistList().remove(playlist);
    }
}
