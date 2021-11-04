package Entities;

import Entities.User;
import Entities.Playlist;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

public class PlaylistTest {
    Playlist playlist;

    @Before("")
    public void setUp(){
        Playlist playlist = new Playlist("Playlist1");
    }

    @After("")
    public void tearDown(){
    }

    @Test
    public void testAddSong(){
        Song song = new Song("Hello", "Adele");
        boolean success = playlist.addSong(song);
        assert(success);
    }
}
