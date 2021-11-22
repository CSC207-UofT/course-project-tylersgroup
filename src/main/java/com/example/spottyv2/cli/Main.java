package com.example.spottyv2.cli;

public class Main {

    public static void main(String[] args) {
        //TODO: Add the login UI steps once created.

        UserAuthenticationUI userAuthenticationUI = new UserAuthenticationUI();
        String username = userAuthenticationUI.authentication(); //returns username
        System.out.println(username);
        // null is returned when the user wants to exit
        if (username == null){
            System.out.println("Thanks for using the spottyApp!");

        } else{
            //After authenticating the user we start the home UI.
            HomeUI homeUI = new HomeUI(username);

            homeUI.runHome();

        }
    }
}

