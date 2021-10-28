package FWDrivers;

import Controllers.ManagePlaylistController;
// TODO: WTF THIS IS NOT ALLOWED - created and commented by tyler for now
import Entities.User;

import java.util.Scanner;

public class ManagePlaylistUI {
    private boolean running;
    private User currentUser;

    public ManagePlaylistUI(User user) {
        this.running = true;
        this.currentUser = user;
    }

    public void managePlaylist(ManagePlaylistController controller){
        printManagePlaylistOptions();

        Scanner input = new Scanner(System.in);

        while (this.running) {
            // Print all available playlists to the user.
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
                    System.out.println("Playlist removed.");
                    controller.callingRemovePlaylist(playlistIndex, currentUser);
                }
                else{
                    // Rename Playlist

                    String newName = getNewNameForPlaylist();

                    System.out.println("Playlist renamed.");
                    controller.callingRenamePlaylist(playlistIndex, currentUser, newName);
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
        // TODO: Controller to get user

    }
}
