package com.example.spottyv2.api.Serializer;

import com.example.spottyv2.Entities.Playlist;
//import com.github.cliftonlabs.json_simple.JsonArray;
//import com.github.cliftonlabs.json_simple.JsonObject;
//import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;
//import com.github.dozermapper
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonSerializer {

//    public Playlist createjson(Playlist playlist) {
//        try {
//            BufferedWriter writer = Files.newBufferedWriter(Paths.get("playlist.json"))
//            //String json = Jsoner.serialize(playlist);
//            Jsoner.serialize(playlist, writer);
//            //json = Jsoner.prettyPrint(json);
//            writer.close()
//
//        } catch (Exception ex) {
//            ex.printStackTrace() //edit
//        }
//    }

    public void createjsons(ArrayList<Playlist> playlists) {
        try { // might need to be a List not an arrayList
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("playlists.json"));
            //String json = Jsoner.serialize(playlist);
            Jsoner.serialize(playlists, writer);
            //json = Jsoner.prettyPrint(json);
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace(); //edit
        }
    }


//    public Playlist deserialize() {
//        Playlist playlist = new Playlist();
//        try {
//            Reader reader = Files.newBufferedReader(Paths.get("playlists.json"))
//            JsonArray objects = Jsoner.deserializeMany(reader);
//            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
//            // Mapper through spring?
//            JsonArray array = (JsonArray) playlists.get(0);
//            ArrayList<Playlist> playlists = array.stream()
//                    .map(obj -> mapper.map(obj, Playlist.class))
//                    .collect(Collectors.toList());
//            // add a return statement? pass to another class
//            reader.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//   }

//    public ArrayList<Playlist> getPlaylists() {
//        ArrayList<Playlist> playlists = new ArrayList<>();
//        File folder = new File("/Users/maxbridgewater/IdeaProjects/course-project-tylersgroup1/SerializedPlaylists");
//        File[] listOfFiles = folder.listFiles();
//        assert listOfFiles != null;
//        for (File listOfFile : listOfFiles) {
//            if (listOfFile.isFile()) {
//                playlists.add(deserialize(listOfFile.getName()));
//            }
//        }
//        return playlists;
//    }
}
