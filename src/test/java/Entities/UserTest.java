//package Entities;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserTest extends TestCase {
//    User user;
//
//    public void setUp(){
//        user = new User("username", "password");
//    }
//
//    public void tearDown() {
//    }
//
//    public void testGetUsername() {
//        String s = user.getUsername();
//        assertEquals("username", s);
//    }
//
//    public void testGetPassword() {
//        String s = user.getPassword();
//        assertEquals("password", s);
//    }
//
//    public void testGetPlaylistList() {
//        List<Playlist> playlistList = user.getPlaylistList();
//        List<Playlist> pll = new ArrayList<>();
//        assertEquals(pll, playlistList);
//    }
//
//    public void testUpdatePlaylistList() {
//    }
//
//    public void testTestToString() {
//    }
//}