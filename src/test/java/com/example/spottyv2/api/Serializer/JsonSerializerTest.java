package com.example.spottyv2.api.Serializer;

import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.Song;
import com.example.spottyv2.Entities.User;
import com.example.spottyv2.UseCases.UserFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonSerializerTest {
    private ObjectMapper objectMapper;
    private User user1;
    private String username1;
    private JsonSerializer serializer;
    private File json;

    @BeforeEach
    void setUp() throws IOException {
        serializer = new JsonSerializer();
        objectMapper = new ObjectMapper();
        Song song1 = new Song("Stay", "Rihanna");
        Song song2 = new Song("Alive", "Beyonce");
        Playlist playlist1 = new Playlist("playlist1");
        playlist1.addSong(song1);
        playlist1.addSong(song2);
        List<Playlist> playlistList = new ArrayList<>(1);
        playlistList.add(playlist1);
        user1 = new User("username", true);
        username1 = user1.getUsername();
        json = new File ("testJson.json");
        objectMapper.writeValue(json, user1);
    }

    @AfterEach
    void tearDown() {
        objectMapper = null;
    }

    @Test
    public void testSerializingWithJsonValue() throws JsonProcessingException{
        String jsonString = objectMapper.writeValueAsString(new ValueDemoBean());
        System.out.println(jsonString);
        assertThat(jsonString, containsString("James Clark"));
        assertThat(jsonString, containsString("James Clark,123"));
    }

    @Test
    void testloggedInUserInfo() throws JsonProcessingException {
        User user = serializer.loggedInUserInfo(username1);
        asserEquals(user, user1);
    }


    @Test
    void saveUser() {
        objectMapper.
        assertThat()
    }

    @Test
    void usersToJson() {
    }

    @Test
    void playlistToJson() {
    }

    @Test
    void readJson() {
    }

    @Test
    void comparator() {
    }
}