package UseCases;
/*
Unit tests for UserManager.java
 */
import com.example.spottywebapp.UseCases.SongGenerator;
import com.example.spottywebapp.Entities.Song;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import java.util.Objects;



public class SongGeneratorTest {

    @Before("")
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

