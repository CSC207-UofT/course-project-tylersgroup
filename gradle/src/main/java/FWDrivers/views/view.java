package FWDrivers.views;

import java.util.ArrayList;

public abstract class view {
    private final ArrayList<String> menuOptions;
    private final String header;

    /**
     * Abstract constructor for the view class.
     * @param menuOptions Stores the menu options available to the user in each view window.
     * @param header Stores the text displayed at the top of the UI in the current view.
     */
    public view(ArrayList<String> menuOptions, String header){

        this.menuOptions = menuOptions;
        this.header = header;
    }

    public String getHeader(){
        return this.header;
    }

    public ArrayList<String> getMenuOptions(){
        return this.menuOptions;
    }

}
