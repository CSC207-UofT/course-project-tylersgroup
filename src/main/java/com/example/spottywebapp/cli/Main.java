package com.example.spottywebapp.cli;

public class Main {

    public static void main(String[] args) {
        //TODO: Add the login UI steps once created.

        //After authenticating the user we start the home UI.
        HomeUI homeUI = new HomeUI();

        homeUI.runHome();

    }
}
