package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.UserManager;
import com.example.spottywebapp.entities.UserList;

public class UserResisterController {

    private UserManager userManager;
    /**
     * A new UserResisterController .
     * @param users a list of users
     */
    public UserResisterController(UserList users) {
        this.userManager = new UserManager(users);
    }
    /**
     * Check to see if the username is unique.
     * @param username username to be checked
     * @return true if the username already exists
     */
    public boolean catchUser(String username) {
        return this.userManager.concurrentUser(username);
    }
    /**
     * Registers a new User in our user list.
     * @param username username for the user to be registered
     * @param password password for the user to be registered
     * @return true if the username already exists
     */
    public boolean registerUser(String username, String password){
        return this.userManager.addUser(username, password);
    }

}
