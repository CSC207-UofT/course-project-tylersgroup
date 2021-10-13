package UseCases;

import Entities.Song;
import Entities.User;

import java.io.*;
import java.util.Optional;

public class SongGenerator {
    static String potentialSong;
    static boolean songExistence;
    static String artist;

    public SongGenerator(String potentialSong){
        SongGenerator.potentialSong = potentialSong;
        SongGenerator.songExistence = false;
        SongGenerator.artist = "";
    }

    public void CSVReader(){

        String path = "sample_data.csv"; // csvFile name goes here
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (SongGenerator.potentialSong.equals(data[0])) {
                    SongGenerator.songExistence = true;
                    SongGenerator.artist = data[1];
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Optional<Entities.Song> generateSong(){
        if(SongGenerator.songExistence){
            Song song = new Song(SongGenerator.potentialSong, SongGenerator.artist);
            Optional<Song> opt = Optional.ofNullable(song);
            return opt;
        }
        return null;
    }

}
