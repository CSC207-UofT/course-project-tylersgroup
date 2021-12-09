package com.example.spottyv2.Controllers;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPlaylists() {
        UserController controller = new UserController();
        User user = new User();
        Playlist pl1 = new Playlist("pl1");
        Playlist pl2 = new Playlist("pl2");
        ArrayList<Playlist> playlists = new ArrayList<>();
        playlists.add(pl1);
        playlists.add(pl2);
        user.addPlaylist(pl1);
        user.addPlaylist(pl2);
        ArrayList<Playlist> userPlaylists = controller.getPlaylists(user);
        assertEquals(playlists, userPlaylists);
    }
}