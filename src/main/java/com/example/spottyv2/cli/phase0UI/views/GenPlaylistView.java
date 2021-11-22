package com.example.spottyv2.cli.phase0UI.views;

public class GenPlaylistView extends View implements ITextField{
    private final View nextView;

    public GenPlaylistView(){
        super.header = "Please type in a sentence or word below:";
        super.menuView = false;
        super.footer = "";
        this.nextView = null;


    }

    @Override
    public String toString(){
        return super.header;

    }

    @Override
    public void updateCurrentFooter(int i) {
        //TODO
    }

    @Override
    public String[] getTextFields() {
        return new String[0];
    }


    @Override
    public void modifyFooter(String newFooter) {
        this.footer = newFooter;
    }

    @Override
    public View getNextView() {
        return this.nextView;
    }
}
