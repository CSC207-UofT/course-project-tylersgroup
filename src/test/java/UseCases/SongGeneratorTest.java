package UseCases;
/*
Unit tests for UserManager.java
 */
import org.junit.*;
import Entities.Song;
import UseCases.SongGenerator;

import java.util.Objects;

import static org.junit.Assert.*;


public class SongGeneratorTest {

    @Before
    public void setUp(){
    }

    @Test
    public void testCSVReader(){
        String success = SongGenerator.CSVReader("the");
        if (!Objects.equals(success, "Michael")) throw new AssertionError();
    }

    @Test
    public void testGenerateSong(){
        Song success = SongGenerator.generateSong("the");
        Song song = new Song("the", "Michael");
        if (!Objects.equals(success.toString(), song.toString().toString())) throw new AssertionError();
    }

}

