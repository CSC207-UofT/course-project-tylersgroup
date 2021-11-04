/*
 * A Use Case class
 *
 * UserManager manages all the users who use the program.
 */
package com.example.spottywebapp.UseCases;

import com.example.spottywebapp.entities.User;
import com.example.spottywebapp.entities.UserList;

import java.util.*;

public class UserManager {
    // Making UserManager a singleton
    private static UserManager USERMANAGER = null;

    // instance attributes of UserManager
    private UserList users;

    private UserManager(){
        users = new UserList();
    }

    public void setUserList(UserList users){
        this.users = users;
    }

    public static UserManager getInstance(){
        if (USERMANAGER == null){
            USERMANAGER = new UserManager();
        }
        return USERMANAGER;
    }

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
        if (this.users.concurrentUser(username)) {
            return false;
        } else {
            this.users.addUser(username, newUser);
            return true;
        }
    }

    public boolean deleteUser(String username){
        if (this.users.concurrentUser(username)){
            this.users.removeUser(username);
            return true;
        }
        else{
            return false;
        }
    }


    public User getUser(String username){
        return users.getUser(username);
    }
}