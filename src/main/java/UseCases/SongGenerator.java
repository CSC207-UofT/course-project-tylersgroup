package UseCases;

import Entities.Song;

import java.io.*;

public class SongGenerator {

    public SongGenerator(String potentialSong){
    }

    public static String CSVReader(String s){

        String path = "sample_data.csv"; // csvFile name goes here
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (s.equals(data[0])) {
                    return data[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static Song generateSong(String s){
        String artist = SongGenerator.CSVReader(s);
        if (artist != ""){
            return new Song(s, artist);
        }
        return null;
    }

}
