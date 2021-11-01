package com.example.spottywebapp.cli.phase0UI.views;

import java.util.LinkedHashMap;

public abstract class View {
    LinkedHashMap<String, View> menuOptions;
    String header;
    String footer;
    boolean menuView;

    /**
     * Abstract constructor for the view class.
     * Instantiates the basic variables needed for any view object.
     *
     */
    public View(){
        header = "";
        footer = "";
        this.menuOptions = new LinkedHashMap<>();
        this.menuView = true;
    }

    public String getHeader(){
        return this.header;
    }

    public LinkedHashMap<String, View> getMenuOptions(){
        return this.menuOptions;
    }

    public String getFooter() {
        return this.footer;
    }

    public boolean isMenuView(){
        return this.menuView;
    }


    @Override
    public String toString(){
        StringBuilder out = new StringBuilder(this.header);

        for(int i = 0; i < this.menuOptions.size();){
            out.append("\n\t").append(i).append(") ").append(menuOptions.keySet().toArray()[i]);
            i++;
        }
        out.append("\n");
        out.append(this.footer);

        return out.toString();
    }
}
