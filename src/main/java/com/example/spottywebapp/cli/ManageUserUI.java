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
                break;
            }

            try {
                int action = Integer.parseInt(userIn);
                // Since index starts at 0 but list number starts at 1

                // Choose the action performed
                if (action == 1) {
                    // Change password
                    String newPassword = getNewPassword();
                    changePassword(newPassword);
                } else if (action == 2) {
                    // delete account
                    removeUser();
                    this.running = false;
                    return 1000;
                }
                else{
                    System.out.println("No such option!");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input: Please enter \"exit\" or a number");
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
        ManageUserController controller = new ManageUserController();
        controller.removeUser(username);
    }

    private void changePassword(String newPassword){
        ManageUserController controller = new ManageUserController();
        controller.changePassword(username, newPassword);
    }

    private void printManageUserOptions(){
        System.out.println("Choose an action, or type \"exit\" to exit:");
        System.out.println("1. Change Password\n2. Delete Account");
    }
}
