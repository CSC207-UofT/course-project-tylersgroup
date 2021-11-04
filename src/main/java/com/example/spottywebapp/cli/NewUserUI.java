package com.example.spottywebapp.cli;

import com.example.spottywebapp.Controllers.UserResisterController;

import java.util.Scanner;

public class NewUserUI {
    private boolean running;
    private boolean registered;

    public NewUserUI(){
        this.running = true;
        this.registered = false;
    }

    /**
     * A new user registration.
     * @param controller UserResisterController for executing registration
     * @return string of username
     */
    public String RegisterUser(UserResisterController controller){
        System.out.println("Please follow the instructions below to create a new account. \n ");
        Scanner input = new Scanner(System.in);

        while (this.running && !this.registered) {
            System.out.println("Please input a username for a new account or type exit: ");
            String userIn = input.nextLine();

            // user input was not exit --> proceed to creating a new User account
            if (!userIn.equals("exit")) {

                if (!controller.catchUser(userIn)) {
                    //username is unique, so user can proceed to inputting password
                    System.out.println("Please input a password for the new account:");
                    String pswd = input.nextLine();

                    if (controller.registerUser(userIn, pswd)) { // if adding a new user to UserList was successful
                        System.out.println("You are all set! Enjoy Spotty App!");
                        this.registered = true;
                        return userIn;
                    } else {
                        System.out.println("Something went wrong, try again.");
                        this.registered = false;
                    }
                } else { // username is not unique, user taken back to the UserAuthenticationUI
                    System.out.println("The username " + userIn + " has already been registered. " +
                                        "Please input a different username. \n ");
                    this.registered = false;
                }

            } else { // user types in "exit"
                this.running = false;
                //TODO: figure out a way to let the user exit
            }
        }
        return null;
    }
}
