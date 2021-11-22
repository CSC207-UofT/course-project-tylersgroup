package com.example.spottyv2.cli;


import com.example.spottyv2.Controllers.ManagePlaylistController;

import java.util.Scanner;

/**
 * The UI responsible for managing playlists
 */
public class ManagePlaylistUI {
    private boolean running;
    private String username;

    public ManagePlaylistUI(String username) {
        this.running = true;
        this.username = username;
    }

    public void managePlaylist(){
        // Scanner for input
        Scanner input = new Scanner(System.in);

        while (this.running) {
            // Print all available playlists to the user.
            printManagePlaylistOptions();
            printUserPlaylist();

            // Find user input
            String userIn = input.next();

            if (userIn.equals("exit")){
                this.running = false;
                break;
            }

            try {
                int playlistIndex = Integer.parseInt(userIn);

                // TODO: Assume the input is valid (Index is within the length of the list of Playlist)

                // select playlist by index
                printPlaylistOptions(playlistIndex);
                // Since index starts at 0 but list number starts at 1
                playlistIndex--;

                // Choose the action performed on the playlist (delete or rename)
                int action = input.nextInt();

                // Handle Exception
                if (action == 1){
                    // Delete Playlist
                    deletePlaylist(playlistIndex);
                    System.out.println("Playlist removed.");
                }
                else if (action == 2){
                    // Rename Playlist
                    String newName = getNewNameForPlaylist();
                    editPlaylistName(playlistIndex, newName);
                    System.out.println("Playlist renamed.");
                }
                else{
                    System.out.println("No such option!");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Invalid input: Please enter \"exit\" or a number");
            }



        }
    }
    private String getNewNameForPlaylist(){
        System.out.println("Enter a new name for the playlist:");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    private void printManagePlaylistOptions(){
        System.out.println("Choose the playlist you want to manage, or type \"exit\" to exit:");
    }

    private void printUserPlaylist(){
        ManagePlaylistController.printUserPlaylist(username);
    }

    private void printPlaylistOptions(int playlistIndex){
        System.out.println("You've selected Playlist " + playlistIndex + ".");
        System.out.println("Choose an action: \n1. Delete Playlist\n2. Rename Playlist");
    }


    private void deletePlaylist(int playlistIndex){
        ManagePlaylistController.callingRemovePlaylist(playlistIndex, username);
    }

    private void editPlaylistName(int playlistIndex, String newName){
        ManagePlaylistController.callingRenamePlaylist(playlistIndex, username, newName);
    }
}
