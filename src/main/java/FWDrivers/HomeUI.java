package FWDrivers;

import Controllers.makePlaylistController;
import Entities.Playlist;
import Entities.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class HomeUI {

    private User currentUser;
    private boolean running;

    public HomeUI(){
        // TODO: Remove this dangerous User placeholder!
        // UI access the user's playlist
        currentUser = new User("username", "password");
        List<Playlist> playlistList = new ArrayList<>();
        playlistList.add(new Playlist("Favourite"));
        playlistList.add(new Playlist("I hate these songs"));
        playlistList.add(new Playlist("ENGLISH SONGS"));
        currentUser.updatePlaylistList(playlistList);
        this.running = true;
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
                        GenPlaylistUI genPlaylistUI = new GenPlaylistUI();
                        makePlaylistController PLController = new makePlaylistController();
                        genPlaylistUI.runPlaylistGen(PLController);
                        break;
                    case 2:
                        // Manage saved playlists
                        ManagePlaylistUI managePlaylistUI = new ManagePlaylistUI(currentUser);
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
