package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.UserManager;
import com.example.spottywebapp.entities.User;

public class GetUserController {
    public static User getUser(String username){
        UserManager usermanager = UserManager.getInstance();
        //TODO: this can throw an exception so check if the user exists with concurrentUser method before calling getUser
        return usermanager.getUser(username);
    }
}
