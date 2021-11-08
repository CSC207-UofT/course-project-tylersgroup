package com.example.spottywebapp.cli;

import com.example.spottywebapp.Controllers.ManageUserController;
import java.util.Scanner;

public class ManageUserUI {
    private boolean running;
    private String username;

    public ManageUserUI(String username){
        this.running = true;
        this.username = username;
    }

    /**
     * Change password or delete user
     * @return integer 1000 if the user deletes his/her account
     */
    public int manageUser(){
        // Scanner for input
        Scanner input = new Scanner(System.in);

        while (this.running) {
            // Print all available manager user options to the user.
            printManageUserOptions();

            // Find user input
            String userIn = input.next();

            if (userIn.equals("exit")){
                this.running = false;
            }
            else {
                int action = Integer.parseInt(userIn);
                // Since index starts at 0 but list number starts at 1
                action--;

                // Choose the action performed
                if (action == 1){
                    // Change password
                    String newPassword = getNewPassword();
                    changePassword(newPassword);
                }
                else if (action == 2){
                    // delete account
                    removeUser();
                    this.running = false;
                    return 1000;
                }
            }


        }
        return 0;
    }

    private String getNewPassword(){
        System.out.println("Enter a new password: ");
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    private void removeUser(){
        ManageUserController.removeUser(username);
    }

    private void changePassword(String newPassword){
        ManageUserController.changePassword(username, newPassword);
    }

    private void printManageUserOptions(){
        System.out.println("Choose an action, or type \"exit\" to exit:");
        System.out.println("1. Delete Playlist\n2. Rename Playlist");
    }
}
