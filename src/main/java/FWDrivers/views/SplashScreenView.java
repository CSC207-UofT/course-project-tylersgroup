package FWDrivers.views;

import java.util.LinkedHashMap;

public class SplashScreenView extends View {

    /**
     * Creates the SplashScreen subclass of view with the text to display the Splash Screen.
     */
    public SplashScreenView(){
        super.header = "Welcome to spottyApp please select from one of the options below:";
        super.footer = "Please input one of the numbers available: ";
        super.menuOptions = new LinkedHashMap<>();
        super.menuOptions.put("Login", new LoginScreenView());
        super.menuOptions.put("Create new account", new CreateAccScreenView());
        super.menuOptions.put("Exit", null);
    }

//    public static void main(String[] args){
//        View test = new SplashScreen();
//        System.out.println(test);
//    }

}
