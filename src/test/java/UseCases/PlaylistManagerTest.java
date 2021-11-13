package UseCases;/*
Unit tests for PlaylistManager.java
*/

import com.example.spottywebapp.Entities.Playlist;
import com.example.spottywebapp.UseCases.PlaylistManager;
import com.example.spottywebapp.UseCases.UserManager;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

public class PlaylistManagerTest {
    PlaylistManager playlistManager = PlaylistManager.getInstance();
    UserManager userManager = UserManager.getInstance();
    Playlist playlist1;
    Playlist playlist2;
    String username;

    @Before("")
    public void setUp(){
        playlist1 = new Playlist("playlist1");
        username = "username";
    }

    @After("")
    public void tearDown(){

    }

    @Test
    public void testAddPlaylist(){
        userManager.createAndAddUser(username, "password");
        boolean success = playlistManager.addPlaylist(playlist1, username);
        assert(success);
    }

    @Test
    public void testRemovePlaylistSuccess(){
        userManager.createAndAddUser(username, "password");
        playlistManager.addPlaylist(playlist1, username);
        boolean success = playlistManager.removePlaylist(playlist1, username);
        assert(success);
    }

    @Test
    public void testRemovePlaylistFailure(){
        userManager.createAndAddUser(username, "password");
        playlistManager.addPlaylist(playlist1, username);
        playlist2 = new Playlist("playlist2");
        boolean success = playlistManager.removePlaylist(playlist2, username);
        assert(!success);
    }

}
