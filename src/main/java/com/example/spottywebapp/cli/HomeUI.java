package com.example.spottywebapp.cli;

import com.example.spottywebapp.Controllers.GetUserController;
import com.example.spottywebapp.Entities.User;
import com.example.spottywebapp.Controllers.MakePlaylistController;

import java.util.InputMismatchException;
import java.util.Scanner;


public class HomeUI {

    private String username;
    private boolean running;

    public HomeUI(String username){
        // GetUserController will return the User object.
        this.running = true;
        this.username = username;
    }

    public void runHome() {

        Scanner input = new Scanner(System.in);

        while (this.running){

            System.out.println("Please select what you would like to do from the options below:"
                    + "\n 1) Generate a new playlist"
                    + "\n 2) Manage saved playlists"
                    + "\n 3) Account Settings"
                    + "\n 4) Exit"
                    + "\n\n Please input one of the numbers available:");

            try {
                int numIn = input.nextInt();

                //TODO: Change the placeholders to be similar to case 1.
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
        System.out.println("Thanks for using the spottyApp!");



    }
}
