package FWDrivers.legacy;

import FWDrivers.legacy.views.View;

public class AppState{

    private static boolean running;

    /**
     * Constructs an appState object that holds the states the program can take:
     * splash screen, login, create new account, create new playlist, manage saved playlists,
     * and account settings.
     */
    public AppState(){
        running = true;

    }

    public boolean isRunning() {
        return running;
    }

    public void stopProgram() {
        running = false;
    }

    public String renderHome(){
        return "Please select what you would like to do from the options below:" + "\n 1) Generate a new playlist"
                + "\n 2) Manage saved playlists" + "\n 3) Account Settings" + "\n 4) Exit"
                + "\n\n Please input one of the numbers available or type exit: ";
    }

    }

