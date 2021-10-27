package FWDrivers;

import Controllers.makePlaylistController;

import java.util.InputMismatchException;
import java.util.Scanner;


public class HomeUI {

    private boolean running;

    public HomeUI(){
        this.running = true;
    }

    public void runHome() {

        Scanner input = new Scanner(System.in);

        while (this.running){

            System.out.println("Please select what you would like to do from the options below:" + "\n 1) Generate a new playlist"
                    + "\n 2) Manage saved playlists" + "\n 3) Account Settings" + "\n 4) Exit"
                    + "\n\n Please input one of the numbers available:");

            try {
                int numIn = input.nextInt();

                //TODO: Change the placeholders to be similar to case 1.
                switch (numIn) {
                    case 1:
                        // Generate a new playlist
                        GenPlaylistUI genPlaylistUI = new GenPlaylistUI();
                        makePlaylistController PLController = new makePlaylistController();
                        genPlaylistUI.runPlaylistGen(PLController);
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
