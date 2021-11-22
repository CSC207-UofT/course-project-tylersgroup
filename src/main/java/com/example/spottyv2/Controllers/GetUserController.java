package com.example.spottyv2.Controllers;

import com.example.spottyv2.Entities.User;
import com.example.spottyv2.UseCases.UserManager;


// TODO: this method is not used anymore
public class GetUserController {
    public static User getUser(String username){
        UserManager usermanager = UserManager.getInstance();
        //TODO: this can throw an exception so check if the user exists with concurrentUser method before calling getUser
        return usermanager.getUser(username);
    }
}
