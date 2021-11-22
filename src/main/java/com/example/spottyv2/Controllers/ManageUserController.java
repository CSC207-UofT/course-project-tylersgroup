package com.example.spottyv2.Controllers;


import com.example.spottyv2.UseCases.UserManager;

/**
 * A controller class
 *
 * ManageUserController works with the UI to manage users.
 */
public class ManageUserController {
    private static UserManager userManager;

    public ManageUserController(){
        userManager = UserManager.getInstance();
    }

    /**
     * Removes the user.
     * @param username username of user
     */
    public void removeUser(String username){
        userManager.deleteUser(username);
    }

    /**
     * Changes the password of user.
     * @param username username of user
     * @param newPassword new password
     */
    public void changePassword(String username, String newPassword){
        userManager.changePassword(username, newPassword);
    }
}
