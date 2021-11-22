package com.example.spottyv2.cli;

import com.example.spottyv2.Controllers.LoginController;

import java.util.Scanner;

/**
 * LoginUI.
 */
public class LoginUI {
    private boolean running;

    public LoginUI() {
        this.running = true;
    }

    /**
     * Login UI. Reads the user's input for username and password and pass these input to the controller
     *
     * @param controller a LoginController
     * @return string of username when log in successful or null if failed to log in
     */
    public String runLogin(LoginController controller) {
        while (this.running) {
            System.out.println("Type \"exit\" or type in your username: ");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();
            System.out.println("Type \"exit\" or type in your password: ");
            String password = scanner.nextLine();
            LoginController.LoginControllerResult result = controller.runLogin(username, password);
            switch (result) {
                case SUCCESS:
                    System.out.println("Logged in.");
                    this.running = false;
                    return username;
                case FAILURE:
                    System.out.println("Failed to login!");
                case NO_SUCH_USER:
                    System.out.println("No such user... Try again.");
            }
        }
        return null;
    }
}
