package com.example.spottyv2.api.Serializer;

import com.example.spottyv2.Entities.Playlist;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class JsonSerializer {

    public void createjson(Jsonable object) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("playlist.json"));
            //String json = Jsoner.serialize(playlist);
            Jsoner.serialize(object, writer);
            //json = Jsoner.prettyPrint(json);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace(); //edit
        }
    }

    public void createjsons(ArrayList<Jsonable> objects) {
        try { // might need to be a List not an arrayList
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("SerializedPlaylists/jsonables"));
            //String json = Jsoner.serialize(playlist);
            Jsoner.serialize(objects, writer);
            //json = Jsoner.prettyPrint(json);
            writer.close();

        } catch (Exception ex) {
            ex.printStackTrace(); //edit
        }
    }

    // deserializes and gets playlists in one go, maybe create a helper
    public ArrayList<Playlist> getPlaylist() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("SerializedPlaylists/jsonables"));
            JsonArray objects = Jsoner.deserializeMany(reader);
            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
            // Mapper through spring?
            JsonArray array = (JsonArray) objects.get(0);
            ArrayList<Playlist> playlists = (ArrayList<Playlist>) array.stream()
                    .map(obj -> mapper.map(obj, Playlist.class))
                    .collect(Collectors.toList());
            reader.close();
            return playlists;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null; // if this doesn't work, move this into the exception catch statement
   }
}
