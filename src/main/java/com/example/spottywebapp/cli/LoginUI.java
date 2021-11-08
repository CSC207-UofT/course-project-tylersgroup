package com.example.spottywebapp.cli;

import com.example.spottywebapp.Controllers.LoginController;

import java.util.Scanner;

/**
 * LoginUI.
 */
public class LoginUI {

    /**
     * Login UI. Reads the user's input for username and password and pass these input to the controller
     *
     * @param controller a LoginController
     * @return string of username when log in successful or null if failed to log in
     */
    public String runLogin(LoginController controller){
        System.out.println("Username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        LoginController.LoginControllerResult result = controller.runLogin(username, password);
        switch (result){
            case SUCCESS:
                System.out.println("Logged in.");
                return username;
            case FAILURE:
                System.out.println("Failed to login!");
                return null;
            case NO_SUCH_USER:
                System.out.println("No such user... Try again.");
                return null;
        }
        return username;
    }
}
