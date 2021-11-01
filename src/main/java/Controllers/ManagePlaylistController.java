package Controllers;

import Entities.User;
import UseCases.PlaylistManager;

public class ManagePlaylistController {
    // Default constructor

    // TODO: Static or create new object?
    public static void callingRenamePlaylist(int playlistIndex, User user, String newName){
        PlaylistManager.renamePlaylist(playlistIndex, user, newName);
    }

    public static void callingRemovePlaylist(int playlistIndex, User user){
        PlaylistManager.removePlaylist(playlistIndex, user);
    }

    public static void printUserPlaylist(User user){
        PlaylistManager.printUserPlaylist(user);
    }
}
