package com.example.spottyv2.Controllers;

import com.example.spottyv2.Entities.User;
import com.example.spottyv2.UseCases.UserFactory;

public class MakeUserController {

    public User makeUser(String userID, boolean spotify){
        UserFactory userFactory = new UserFactory();

        if (spotify){
            return userFactory.makeSpotifyUser(userID);
        }else{
            return userFactory.makeDefaultUser(userID);
        }

    }
}
