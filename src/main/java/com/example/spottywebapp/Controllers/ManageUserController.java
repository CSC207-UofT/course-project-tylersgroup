package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.UserManager;

/**
 * A controller class
 *
 * ManageUserController works with the UI to manage users.
 */
public class ManageUserController {
    // Default constructor

    /**
     * Removes the user.
     * @param username username of user
     */
    public static void removeUser(String username){
        UserManager.deleteUser(username);
    }

    /**
     * Changes the password of user.
     * @param username username of user
     * @param newPassword new password
     */
    public static void changePassword(String username, String newPassword){
        UserManager.changePassword(username, newPassword);
    }
}
