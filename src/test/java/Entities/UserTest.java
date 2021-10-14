package Entities;

import junit.framework.TestCase;

import java.util.List;

public class UserTest extends TestCase {
    User user;

    public void setUp() throws Exception {
        super.setUp();
        user = new User("username", "password");
    }

    public void tearDown() throws Exception {
    }

    public void testGetUsername() {
        String s = user.getUsername();
        assertEquals("username", s);
    }

    public void testGetPassword() {
        String s = user.getPassword();
        assertEquals("password", s);
    }

    public void testGetPlaylistList() {
        List<Playlist> playlist = user.getPlaylistList();
        assertEquals("password", playlist);
    }

    public void testUpdatePlaylistList() {
    }

    public void testTestToString() {
    }
}