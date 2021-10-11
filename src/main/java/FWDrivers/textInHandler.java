package FWDrivers;

import FWDrivers.views.View;

public class textInHandler {
    private boolean complete;

    /**
     * Constructor for textInHandler which will handle long text inputs from the user
     * based on the current view. Example: if the view is the login window, the textHandler
     * will handle taking the username and password before checking with the authenticator.
     */
    public textInHandler(){
        this.complete = false;
    }

    public void handleText(String input, View currentView){
        //TODO: Implement text handler for various views.

        if (input.equals("jimbean")){ //Quick test to see if it works in the main.
            this.complete = true;
        }
    }

    public boolean getComplete() {
        return this.complete;
    }
}
