package Entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * A map of username —> User object.
 */
// What do we gain by defining this class and storing an instance of it
// in the LogInUseCase class, as opposed to just
// storing a Map<String, User> in the LogInUseCase class?
public class UserList implements Serializable {
    private final Map<String, User> users = new HashMap<>();

    /**
     * Checks if the username already exists in this user list.
     * @param username the username to be checked
     * @return true if the username already exists
     */
    public boolean concurrentUser(String username){
        return users.containsKey(username);
    }

    /**
     * Return the User associated with username.
     * @param username the username of the user to get.
     */
    public User getUser(String username) {
        if (this.concurrentUser(username)){
            return users.get(username);
        } else {
            throw new NoSuchElementException();
        }
    }
    /**
     * Override toString
     * @return user as a string in the form of: This user *username* has *number of playlists* playlist(s).
     **/
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (String key : users.keySet()) {
            sb.append(getUser(key).toString());
        }
        return String.valueOf(sb);
    }

}