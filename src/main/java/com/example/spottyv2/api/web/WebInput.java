package com.example.spottyv2.api.web;


import com.example.spottyv2.api.InputChecker;

/**
 * This is technically an entity class but is used to display information from the server to the client. Basically just
 * a container object for passing information from the clientside to the server.
 */

public class WebInput {
    private String input;
    private int num;
    private String id;

    public WebInput(){
    }

    public WebInput(String input, int num, String id){
        this.input = input;
        this.num = num;
        this.id = id;
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

    public String getId(){ return this.id; }

    public void setId(String id) {

        id = id.split("[,]", 2)[0];
        System.out.println("=========>" + id + "=========*********====");
        this.id = id; }

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
                ", num=" + num + ", id=" + id  +
                '}';
    }
}
