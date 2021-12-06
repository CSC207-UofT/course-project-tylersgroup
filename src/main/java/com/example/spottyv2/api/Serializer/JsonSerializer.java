package com.example.spottyv2.api.Serializer;

import com.example.spottyv2.Controllers.MakeUserController;
import com.example.spottyv2.Controllers.SavePlaylistController;
import com.example.spottyv2.Controllers.UserController;
import com.example.spottyv2.Entities.Playlist;
import com.example.spottyv2.Entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonSerializer {
    private ObjectMapper mapper;

    public JsonSerializer(){
        mapper = new ObjectMapper();
    }

    /**
     * Takes in username that is unique to the currently logged-in user, and returns an instantiated User entity.
     * @param username the username of the user
     * @return the existing user in the list or new User that is instantiated
     */
    public User loggedInUserInfo(String username){
        List<User> users = readJson();
        for (User user: users){
            if (comparator(username, user.getUsername())){
                return user;
            }
        }
        MakeUserController makeUserController = new MakeUserController();
        return makeUserController.makeUser(username, true);
    }

    /**
     * Saves the User loggedInUser to the Json file.
     * @param loggedInUser User that is currently logged-in in this system.
     */
    public void saveUser(User loggedInUser){
        List<User> users = readJson();
        //compare if the user is in users
        for (User user: users) {
            if (comparator(loggedInUser.getUsername(), user.getUsername())) {
                users.remove(user);
                break;
            }
        }
        if (!loggedInUser.getDefaultUser()){
            users.add(loggedInUser);
        }
        usersToJson(users);
    }
    /**
     * Helper method.
     * Convert a list of User users into JsonArray and write to the file.
     * @param users list of User to be written to Json file
     */
    public void usersToJson(List<User> users) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(Paths.get("jsonables.json").toFile(), users);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // https://stackoverflow.com/questions/13514570/jackson-best-way-writes-a-java-list-to-a-json-array
    public void playlistToJson(List<Playlist> playlists){
        try{
            mapper.writeValue(Paths.get("jsonables.json").toFile(), playlists);
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public String playlistToJsonArray(Playlist playlist){
        try{
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(playlist);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Helper method.
     * Reads in a jsonable file that contains JsonArray of json objects that represent User entities.
     * @return a Java list of User
     */
    public List<User> readJson() {
        try {
            //List<User> users = mapper.readValue(Paths.get("jsonables.json").toFile(), new TypeReference<List<User>>() {});
            List<User> users = mapper.readValue(Paths.get("jsonables.json").toFile(), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
            System.out.println(users);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * Helper method.
     * Compare the username of the current user currentUsername and comparison user tempUsername.
     * @return true if currentUsername = tempUsername, false if they are different
     */
    public Boolean comparator (String currentUsername, String tempUsername){
        return currentUsername.equals(tempUsername);
    }

    public void savePlaylistToUser(User user, Playlist playlist){
        SavePlaylistController savePlaylistController = new SavePlaylistController();
        if (savePlaylistController.savePlaylist(user, playlist)){
            this.saveUser(user);
        }
    }

    public ArrayList<Playlist> getPlaylists(User loggedInUser){
        UserController uc = new UserController();
        return uc.getPlaylists(loggedInUser);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // deserializes and gets playlists in one go, maybe create a helper
//    public ArrayList<Playlist> getPlaylist() {
//        try {
//            Reader reader = Files.newBufferedReader(Paths.get("SerializedPlaylists/jsonables"));
//            JsonArray objects = Jsoner.deserializeMany(reader);
//            Mapper mapper = DozerBeanMapperBuilder.buildDefault();
//            // Mapper through spring?
//            JsonArray array = (JsonArray) objects.get(0);
//            ArrayList<Playlist> playlists = (ArrayList<Playlist>) array.stream()
//                    .map(obj -> mapper.map(obj, Playlist.class))
//                    .collect(Collectors.toList());
//            reader.close();
//            return playlists;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null; // if this doesn't work, move this into the exception catch statement
//   }

    public void writeJson(User user) throws IOException {
        JsonNode rootNode = mapper.createObjectNode();
        JsonNode playlistNode = mapper.createArrayNode();
        for (Playlist playlist: user.getPlaylistList()){
            ((ArrayNode)playlistNode).add(playlistToJsonArray(playlist));
        }
        ((ObjectNode) rootNode).put("username", user.getUsername());
        ((ObjectNode) rootNode).put("playlistList", playlistNode);
        mapper.writeValue(Paths.get("jsonables.json").toFile(), rootNode);

    }



}


