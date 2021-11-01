package FWDrivers;

import Controllers.UserResisterController;

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

                    //username is unique, so user can proceed to inputting password
                    if (controller.catchUser(userIn)){
                        System.out.println("Please input a password for the new account:");
                        String pswd = input.nextLine();
                        controller.registerUser(userIn, pswd);
                        System.out.println("You are all set! Enjoy Spotty App!");
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
