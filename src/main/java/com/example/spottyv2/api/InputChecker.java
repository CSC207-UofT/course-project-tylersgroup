package com.example.spottyv2.api;

/**
 * The input checker is a helper class that ensures the user input to the playlist generator screen will be english
 * characters a-z and A-Z.
 */

public class InputChecker {

    public static boolean check(String input){

        //TODO: Werid edge cases where the input " " is let through, and pressing enter gives a song not found??
        return input != null && input.matches("^[a-zA-Z\\s]*$");
        }
}

