package com.example.spottyv2.api;

/**
 * The input checker is a utility class that ensures the user input to the playlist generator screen will be english
 * characters a-z and A-Z.
 */

public class InputChecker {

    public static boolean check(String input){

        return input != null && input.matches("^[a-zA-Z\\s]*$");
        }
}

