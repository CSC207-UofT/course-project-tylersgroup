package com.example.spottyv2.Controllers;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.User;
import com.example.spottyv2.UseCases.SavePlaylistToUser;

public class SavePlaylistController {

    public boolean savePlaylist(User user, Playlist playlist){
        SavePlaylistToUser saver = new SavePlaylistToUser();
        return saver.savePlaylistToUser(user, playlist);
    }


}
