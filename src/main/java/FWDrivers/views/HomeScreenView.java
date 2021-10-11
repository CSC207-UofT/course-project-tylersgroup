package FWDrivers.views;

import java.util.LinkedHashMap;

public class HomeScreenView extends View{

    /**
     * Creates the HomeScreenView subclass of View to display the options available to the user on the
     * home screen.
     */
    public HomeScreenView(){
        super.header = "Successful login!" + "\n" + "Please select what you would like to do from the options below:";
        super.footer = "Please input one of the numbers available: ";
        super.menuOptions = new LinkedHashMap<>();
        super.menuOptions.put("Generate a new playlist", new genPlaylistView());
        super.menuOptions.put("Manage Playlists", new managePlaylistView());
        super.menuOptions.put("Account settings", new accSettingsView());
        super.menuOptions.put("Exit", null);
    }
}
