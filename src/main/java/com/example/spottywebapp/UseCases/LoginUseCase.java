package com.example.spottywebapp.UseCases;


import com.example.spottywebapp.Controllers.UserReadWriter;
import com.example.spottywebapp.Entities.User;
import com.example.spottywebapp.Entities.UserList;

import java.io.IOException;
import java.util.NoSuchElementException;

public class LoginUseCase implements LoginInputBoundary {

    /**
     * A list of users organized by username.
     */
    private final UserList users;

    /**
     * / The "output" of this use case.
     */
    public enum LoginResult {
        SUCCESS, FAILURE, NO_SUCH_USER
    }

    public LoginUseCase(UserReadWriter readWriter, UserList users) {
        this.users = users;
        try {
            readWriter.saveToFile("user_data.ser", users);
        } catch (IOException e) {
            System.out.println("User list did not save.");
        }
    }

    /**
     * Run the login use case.
     *
     * @param username the username
     * @param password the password attempt
     * @return whether the attempt matches the password associated with username
     */
    public LoginResult logIn(String username, String password) {
        try {
            User user = users.getUser(username);
            if (user.passwordMatches(password)) {
                return LoginResult.SUCCESS;
            } else {
                return LoginResult.FAILURE;
            }
        }
        catch (NoSuchElementException e){
            return LoginResult.NO_SUCH_USER;
        }

    }
}