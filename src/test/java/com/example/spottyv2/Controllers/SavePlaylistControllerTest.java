package com.example.spottyv2.Controllers;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SavePlaylistControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void savePlaylist() {
        SavePlaylistController saver = new SavePlaylistController();
        Playlist p1 = new Playlist("pl1");
        User user = new User();
        saver.savePlaylist(user, p1);
        assertTrue(user.getPlaylistList().contains(p1));
        assertEquals(1, user.getPlaylistList().size());
    }
}