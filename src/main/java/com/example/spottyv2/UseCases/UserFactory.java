package com.example.spottyv2.UseCases;

import com.example.spottyv2.Entities.DefaultUser;
import com.example.spottyv2.Entities.SpotifyUser;

public class UserFactory {

    public DefaultUser makeDefaultUser(String userID){
        return new DefaultUser(userID);
    }

    public SpotifyUser makeSpotifyUser(String userID){
        return new SpotifyUser(userID);
    }
}
