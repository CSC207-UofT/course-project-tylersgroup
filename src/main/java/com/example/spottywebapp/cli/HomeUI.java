package com.example.spottywebapp.cli;

import com.example.spottywebapp.Controllers.GetUserController;
import com.example.spottywebapp.Controllers.MakePlaylistController;
import com.example.spottywebapp.entities.User;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The UI for Homepage
 */
public class HomeUI {

    private String username;
    private boolean running;

    /**
     * Constructor of HomeUI.
     * @param username username of user
     */
    public HomeUI(String username){
        // GetUserController will return the User object.
        this.running = true;
        this.username = username;
    }

    /**
     * Runs the HomeUI.
     */
    public void runHome() {
        // Scanner for input
        Scanner input = new Scanner(System.in);

        while (this.running){
            printOptions();

            try {
                int numIn = input.nextInt();

                switch (numIn) {
                    case 1:
                        // Generate a new playlist
                        GenPlaylistUI genPlaylistUI = new GenPlaylistUI(username);
                        genPlaylistUI.runPlaylistGen();
                        break;
                    case 2:
                        // Manage saved playlists
                        ManagePlaylistUI managePlaylistUI = new ManagePlaylistUI(username);
                        managePlaylistUI.managePlaylist();
                        break;
                    case 3:
                        // User Account
                        System.out.println("Placeholder3");
                        break;
                    case 4:
                        // Exits the while loop which exits the runHome method, exiting the program.
                        this.running = false;
                        input.close();
                        break;
                    default:
                        System.out.println("Invalid input, please try again.");
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid input, please try again. \n");
                input.nextLine();
            }
        }

        endMessage();
    }

    /**
     * Prints available options to the user using the homepage.
     */
    private void printOptions(){
        System.out.println("Please select what you would like to do from the options below:"
                + "\n 1) Generate a new playlist"
                + "\n 2) Manage saved playlists"
                + "\n 3) Account Settings"
                + "\n 4) Exit"
                + "\n\n Please input one of the numbers available:");
    }

    /**
     * Prints closing message to the user.
     */
    private void endMessage(){
        System.out.println("Thanks for using the spottyApp!");
    }
}
