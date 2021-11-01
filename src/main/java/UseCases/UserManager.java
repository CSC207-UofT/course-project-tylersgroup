/*
* A Use Case class
*
* UserManager manages all the users who use the program.
*/
package UseCases;

import Entities.User;
import Entities.UserList;
import java.util.*;

public class UserManager {

    private UserList users;

    /**
     * Constructs a new UserManager with an existent userList.
     *
     * @param userList UserList containing already registered Users
     */
    public UserManager(UserList userList){
        this.users = userList;
    }
    /**
     * Constructs a new UserManager with no userList.
     *
     */
    public UserManager(){users = new UserList();}

    /**
     * Checks if the username already exists in this user list.
     * @param username the username to be checked
     * @return true if the username already exists
     */
    public boolean concurrentUser(String username){
        return users.concurrentUser(username);
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
        if (((Map) users).containsKey(username)) {
            return false;
        } else {
            ((Map) this.users).put(username, newUser);
            return true;
        }
    }

    public boolean deleteUser(String username){
        if (((Map) this.users).containsKey(username)){
            ((Map) this.users).remove(username);
            return true;
        }
        else{
            return false;
        }
    }

    public User getUser(String username){
        return (User) ((Map) users).get(username);
    }
}


