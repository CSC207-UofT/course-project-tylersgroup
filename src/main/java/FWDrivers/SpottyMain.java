package FWDrivers;

import FWDrivers.phase0UI.AppState;

import java.util.Scanner;


public class SpottyMain {
    public static void main(String[] args) {
        // Start a new appstate to keep track of the program current running state.
        AppState state = new AppState();
        // Start a scanner to look for user inputs
        Scanner input = new Scanner(System.in);

        while (state.isRunning()){
            // Render the homescreen text.
            System.out.println(state.renderHome());
            int numIn = input.nextInt();
            //TODO: Change the placeholders to start main methods for handling the displaying and user inputs for the menu options stated.
            switch (numIn){
                case 1:
                    // Generate a new playlist
                    System.out.println("Placeholder1");
                    break;
                case 2:
                    // Manage saved playlists
                    System.out.println("Placeholder2");
                    break;
                case 3:
                    // User Account
                    System.out.println("Placeholder3");
                    break;
                case 4:
                    state.stopProgram();
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }

        }
        System.out.println("Thanks for using the spottyApp!");



    }
}