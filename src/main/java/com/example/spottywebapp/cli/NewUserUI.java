package com.example.spottywebapp.cli;

import com.example.spottywebapp.Controllers.UserResisterController;

import java.util.Scanner;

public class NewUserUI {
    private boolean running;

    public NewUserUI(){
        this.running = true;
    }

    /**
     * A new user registration.
     * @param controller UserResisterController for executing registration
     */
    public void RegisterUser(UserResisterController controller){
        System.out.println("Please follow the instructions below to create a new account. \n ");
        Scanner input = new Scanner(System.in);

        while (this.running){
            System.out.println("Please input a username for a new account or type exit: ");
            String userIn = input.nextLine();

            // user types in a username
            if (!userIn.equals("exit")){

                    if (!controller.catchUser(userIn)){
                        //username is unique, so user can proceed to inputting password
                        System.out.println("Please input a password for the new account:");
                        String pswd = input.nextLine();

                        if (controller.registerUser(userIn, pswd)){ // if adding a new user to userlist was successful
                            System.out.println("You are all set! Enjoy Spotty App!");
                        }

                        else{
                            System.out.println("Something went wrong, try again.");
                            break;
                        }
                    }
                    else { // username is not unique, user taken back to the UserAuthenticationUI
                        System.out.println("The username " +userIn+" has already been registered. \n ");
                    }
                this.running = false; // the username has already been used.
                break;

            }
            else { // user types in "exit"
                this.running = false;
            }
            }
    }
}
