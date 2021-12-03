package com.example.spottyv2;
import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.User;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class JsonTest {
    try {
        // create book object
        List<Playlist> playlistlist = new
        Playlist playlist2 = new Playlist()
        Playlist playlist1 = new Playlist
        User newuser = new User ("123", false, playlist1, playlist2] );

        // convert book object to JSON
        String json = Jsoner.serialize(newuser));

        // prettify JSON
        json = Jsoner.prettyPrint(json);

        // print JSON
        System.out.println(json);

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
