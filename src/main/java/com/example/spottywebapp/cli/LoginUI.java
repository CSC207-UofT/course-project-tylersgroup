package com.example.spottywebapp.cli;

import Controllers.LoginController;

import java.util.Scanner;

public class LoginUI {
    /**
     * Login UI. Reads the user's input for username and password.
     *
     * @param controller a LoginController
     */
    public void runLogin(LoginController controller){
        System.out.println("Username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        controller.runLogin(username, password);
    }
}
