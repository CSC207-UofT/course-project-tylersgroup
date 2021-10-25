package FWDrivers;

import FWDrivers.legacy.AppState;

import java.util.Scanner;


public class SpottyMain {
    public static void main(String[] args) {
        AppState state = new AppState();
        Scanner input = new Scanner(System.in);

        while (state.isRunning()){

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
