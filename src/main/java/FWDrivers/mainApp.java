package FWDrivers;

import FWDrivers.views.SplashScreenView;

import java.util.Scanner;



/**
 * This is the text interface that prompts the user to navigate through the text UI,
 * input data into the program, and allows the program to display information to the user.
 */

public class mainApp {

    public static void main(String[] args){
        // Create an appState object with the SplashScreen view as the starting point for the program.
        appState appState = new appState(new SplashScreenView());

        // Create a stateChanger object to handle how user input changes the program state.
        stateChanger stateChanger = new stateChanger();

        Scanner input = new Scanner(System.in);
        //Reading in the user's choices and executing them while the program is running.
        while (appState.isRunning()){
            System.out.println(appState.getCurrView());
            String userIn = input.nextLine();
            //TODO: Add a try/catch block for invalid user inputs
            stateChanger.changeState(userIn, appState);

            }
        input.close();
        System.out.println("Thanks for using the spottyApp!");
        }

    }
