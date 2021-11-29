package com.example.spottyv2.api.Serializer;

import com.example.spottyv2.Entities.Playlist;

import java.io.*;
import java.util.ArrayList;

public class Serializer {
    private static final String separator = ",";

    public void serialize(Playlist playlist) {
        try {
            File outputFile = new File("SerializedPlaylists/" + playlist.getPlaylistName() + ".ser");
            outputFile.createNewFile();

            FileOutputStream fileOut = new FileOutputStream(outputFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(playlist);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in" + playlist.getPlaylistName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Playlist deserialize(String filename) {
        Playlist playlist = new Playlist();
        try {
            FileInputStream fileIn = new FileInputStream("SerializedPlaylists/" + filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            playlist = (Playlist) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
        return playlist;
    }

    public ArrayList<Playlist> getPlaylists() {
        ArrayList<Playlist> playlists = new ArrayList<>();
        File folder = new File("./SerializedPlaylists");
        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                playlists.add(deserialize(listOfFile.getName()));
            }
        }
        return playlists;
    }
}
