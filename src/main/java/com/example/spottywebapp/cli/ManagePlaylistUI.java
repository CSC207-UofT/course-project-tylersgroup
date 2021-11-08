package com.example.spottywebapp.cli;


import com.example.spottywebapp.Controllers.ManagePlaylistController;
import com.example.spottywebapp.entities.User;

import java.util.Scanner;

public class ManagePlaylistUI {
    private boolean running;
    private String username;

    public ManagePlaylistUI(String username) {
        this.running = true;
        this.username = username;
    }

    public void managePlaylist(){

        Scanner input = new Scanner(System.in);

        while (this.running) {
            // Print all available playlists to the user.
            printManagePlaylistOptions();
            printUserPlaylist();

            String userIn = input.next();

            if (userIn.equals("exit")){
                this.running = false;
            }
            else {
                // TODO: Assume the input is valid (Index is within the length of the list of Playlist)
                int playlistIndex = Integer.parseInt(userIn);
                System.out.println("You've selected Playlist " + playlistIndex + ".");
                System.out.println("Choose an action: \n1. Delete Playlist\n2. Rename Playlist");

                // Since index starts at 0 but list number starts at 1
                playlistIndex--;

                // Choose the action performed on the playlist (delete or rename)
                int action = input.nextInt();
                // TODO: Handle Exception
                if (action == 1){
                    // Delete Playlist
                    deletePlaylist(playlistIndex);
                    System.out.println("Playlist removed.");
                    //this.running = false;
                }
                else if (action == 2){
                    // Rename Playlist

                    String newName = getNewNameForPlaylist();

                    editPlaylistName(playlistIndex, newName);

                    System.out.println("Playlist renamed.");
                    //this.running = false;
                }
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

    private void deletePlaylist(int playlistIndex){
        ManagePlaylistController.callingRemovePlaylist(playlistIndex, username);
    }

    private void editPlaylistName(int playlistIndex, String newName){
        ManagePlaylistController.callingRenamePlaylist(playlistIndex, username, newName);
    }
}
