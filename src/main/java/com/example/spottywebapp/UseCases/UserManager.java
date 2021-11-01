package com.example.spottywebapp.UseCases;

import com.example.spottywebapp.entities.User;
import com.example.spottywebapp.entities.UserList;

import java.util.Map;

/**
This is a use case class for managing users
 */
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
        if (((Map) users).containsKey(username)) {
            return false;
        } else {
            ((Map) this.users).put(username, newUser);
            return true;
        }
    }

    /**
     * Deletes a user entity from the UserManager
     * @param username username of an existing user
     * @return whether the deletion is successful
     */
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


