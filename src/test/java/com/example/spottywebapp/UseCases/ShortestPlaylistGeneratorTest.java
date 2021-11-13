package com.example.spottywebapp.UseCases;

import com.example.spottywebapp.Entities.Playlist;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShortestPlaylistGeneratorTest {

    @Before("")
    public void setup(){

    }


    @Test
    void testGeneratePlaylist() {
        ShortestPlaylistGenerator pg = new ShortestPlaylistGenerator();
        ArrayList<String> words = new ArrayList<>();
        words.add("hello");
        words.add("my");
        words.add("name");

        Playlist newPlaylist = new Playlist("test");

        Playlist output = pg.generatePlaylist(words, newPlaylist);

        System.out.println(output);

    }

    @Test
    void testGeneratePlaylistWeb() {
        ShortestPlaylistGenerator pg = new ShortestPlaylistGenerator();
        ArrayList<String> words = new ArrayList<>();
        words.add("hello");
        words.add("my");
        words.add("name");

        Playlist newPlaylist = new Playlist("test");

        Playlist output = pg.generatePlaylistWeb(words, newPlaylist);

        System.out.println(output);
    }
}