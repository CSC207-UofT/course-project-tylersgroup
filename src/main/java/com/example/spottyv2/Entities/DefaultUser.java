package com.example.spottyv2.Entities;

public class DefaultUser extends User{

    /**
     * Construct a User object, with the following parameter:
     *
     * @param userID        Username of the User
     */
    public DefaultUser(String userID) {
        super(userID, true);
    }
}
