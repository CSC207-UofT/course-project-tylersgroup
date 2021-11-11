package com.example.spottywebapp.api;

/**
 * This is technically a gateway class but is used to display information from the server to the client.
 */

public class WebInput {
    private String input;

    public String getInput(){
        return this.input;
    }

    public void setInput(String input){
        this.input = input;
    }
}
