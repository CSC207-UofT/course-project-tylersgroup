package com.example.spottyv2.UseCases;

import com.example.spottyv2.Entities.Playlist;
import org.junit.Before;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShortestPlaylistGeneratorTest {
    @Before
    public void setup(){

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
