package UseCases;/*
Unit tests for PlaylistManager.java
*/

import com.example.spottywebapp.Entities.Playlist;
import com.example.spottywebapp.Entities.User;
import com.example.spottywebapp.UseCases.PlaylistManager;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

public class PlaylistManagerTest {
    PlaylistManager manager;
    Playlist playlist1;
    Playlist playlist2;
    User user;

    @Before("")
    public void setUp(){
        manager = new PlaylistManager();
        //TODO: Make the constructor of Playlist public
        playlist1 = new Playlist("playlist1");
        playlist2 = new Playlist("playlist2");
        user = new User("username", "password");
    }

    @After("")
    public void tearDown(){

    }

//    @Test
//    public void testAddPlaylist(){
//        boolean success = manager.addPlaylist(playlist1, user);
//        assert(success);
//    }
//
//    @Test
//    public void testRemovePlaylistSuccess(){
//        manager.addPlaylist(playlist1, user);
//        boolean success = manager.removePlaylist(playlist1, user);
//        assert(success);
//    }
//
//    @Test
//    public void testRemovePlaylistFailure(){
//        manager.addPlaylist(playlist1, user);
//        boolean success = manager.removePlaylist(playlist2, user);
//        assert(!success);
//    }

}
