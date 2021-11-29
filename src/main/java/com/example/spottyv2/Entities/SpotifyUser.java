package com.example.spottyv2.Entities;

public class SpotifyUser extends User{

    /**
     * Construct a User object, with the following parameter:
     *
     * @param userID        Username of the User
     */
    public SpotifyUser(String userID) {
        super(userID, false);
    }
}
