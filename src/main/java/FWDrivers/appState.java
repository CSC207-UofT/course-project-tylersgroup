package FWDrivers;

import FWDrivers.views.view;

public class appState implements IappState{

    private boolean running;
    private view current_view;

    /**
     * Constructs an appState object that holds the states the program can take:
     * splash screen, login, create new account, create new playlist, manage saved playlists,
     * and account settings.
     */
    public appState(){
        this.running = true;
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    @Override
    public void stopProgram() {
        running = false;
    }
}
