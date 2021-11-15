package com.example.spottywebapp.api.web;

import com.example.spottywebapp.cli.InputChecker;

/**
 * This is technically a gateway class but is used to display information from the server to the client.
 */

public class WebInput {
    private String input;
    private int num;

    public WebInput(){
    }

    public WebInput(String input, int num){
        this.input = input;
        this.num = num;
    }

    public String getInput(){
        return this.input;
    }

    public void setInput(String input){
        this.input = input;
    }

    public int getNum(){
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isValid(){
        return InputChecker.check(this.input);
    }

    @Override
    public String toString() {
        return "WebInput{" +
                "input='" + input + '\'' +
                ", num=" + num +
                '}';
    }
}
