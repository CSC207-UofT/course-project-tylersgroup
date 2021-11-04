package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.UserManager;
import com.example.spottywebapp.entities.User;

public class GetUserController {
    public static User getUser(String username){
        UserManager usermanager = UserManager.getInstance();
        return usermanager.getUser(username);
    }
}
