package FWDrivers;

import FWDrivers.views.View;

public class appState implements IappState{

    private static boolean running;
    private static View currentView;

    /**
     * Constructs an appState object that holds the states the program can take:
     * splash screen, login, create new account, create new playlist, manage saved playlists,
     * and account settings.
     */
    public appState(View view){
        running = true;
        currentView = view;

    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void stopProgram() {
        running = false;
    }

    @Override
    public View getCurrView() {
        return currentView;
    }

    @Override
    public void changeCurView(View view){
        currentView = view;
    }

}
