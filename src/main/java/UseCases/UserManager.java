/*
* A Use Case class
*
* UserManager manages all the users who use the program.
*/
package UseCases;

import Entities.User;
import java.util.*;

public class UserManager {
    private Map<String, User> users;

    public UserManager(){
        users = new HashMap<>();
    }

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

    public boolean deleteUser(String username){
        if (this.users.containsKey(username)){
            this.users.remove(username);
            return true;
        }
        else{
            return false;
        }
    }


    public User getUser(String username){
        return users.get(username);
    }
}
