package UseCases;

import Entities.User;
import java.util.*;

/**
This is a use case class for managing users
 */
public class UserManager {
    private Map<String, User> users;

    public UserManager(){
        users = new HashMap<>();
    }

    /**
     * Adds a user to the UserManager
     * @param username username of a new user
     * @param password password of a new user
     * @return whether adding the user is successful
     */
    public boolean addUser(String username, String password){
        User newUser = createUser(username, password);
        return addNewUser(newUser);
    }

    private User createUser(String username, String password){
        return new User(username, password);
    }

    private boolean addNewUser(User newUser) {
        String username = newUser.getUsername();
        if (this.users.containsKey(username)) {
            return false;
        } else {
            this.users.put(username, newUser);
            return true;
        }
    }

    /**
     * Deletes a user entity from the UserManager
     * @param username username of an existing user
     * @return whether the deletion is successful
     */
    public boolean deleteUser(String username){
        if (this.users.containsKey(username)){
            this.users.remove(username);
            return true;
        }
        else{
            return false;
        }
    }

    public User getUser(String username){ return users.get(username); }
}
