package com.example.spottywebapp.cli;

import com.example.spottywebapp.Controllers.makePlaylistController;

import java.util.Scanner;

public class GenPlaylistUI {
    private boolean running;

    public GenPlaylistUI(){
        this.running = true;
    }

    public void runPlaylistGen(makePlaylistController controller) {

        // Header to print the first time the user sees the generate playlist screen.
        System.out.println("Please follow the instructions below to generate your playlist. \n");

        // Start the scanner for user inputs
        Scanner input = new Scanner(System.in);

        while (this.running) {
            // Print the generator screen text to the user.
            System.out.println("Please input a sentence without any special characters or type exit: ");

            String userIn = input.nextLine();
            if (!userIn.equals("exit")) {
                try {

                    if (InputChecker.check(userIn)) {

                        System.out.println(controller.makePlaylist(userIn));

                    } else {
                        throw new InputException();
                    }

                } catch (InputException e) {
                    System.out.println("Invalid input, check your string for special characters.");
                }

            } else {
                this.running = false;

            }

        }
    }
}
