package Controllers;

import Entities.Playlist;
import Entities.User;
import UseCases.PlaylistManager;

public class ManagePlaylistController {
    // Default constructor


    public void callingRenamePlaylist(int playlistIndex, User user, String newName){
        PlaylistManager.renamePlaylist(playlistIndex, user, newName);
    }

    public void callingRemovePlaylist(int playlistIndex, User user){
        PlaylistManager.removePlaylist(playlistIndex, user);
    }
}
