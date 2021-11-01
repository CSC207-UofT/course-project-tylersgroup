package FWDrivers;

import Controllers.LoginController;
import Controllers.UserResisterController;
import Entities.User;
import Entities.UserList;
import FWDrivers.LoginUI;
import FWDrivers.NewUserUI;
import UseCases.LoginUseCase;
import UseCases.UserReadWriter;

import java.util.InputMismatchException;
import java.util.Scanner;

import java.io.*;



public class UserAuthenticationUI {

    private boolean running;

    public UserAuthenticationUI() {
        this.running = true;
    }

    public void authentication() {
        Scanner input = new Scanner(System.in);
        while (this.running) {
            System.out.println("Please select what you would like to do from the options below:" +
                    " \n 1) Log in" + "\n 2) Create a new account");
            try {
                int numIn = input.nextInt();
                String filepath = "users_data";
                UserReadWriter urw = new UserReadWriter();
                UserList users = urw.readFromFile(filepath);
                switch (numIn) {
                    case 1:
                        LoginUI loginUI = new LoginUI();
                        LoginUseCase useCase = new LoginUseCase(urw, users);
                        LoginController controller = new LoginController(useCase);
                        loginUI.runLogin(controller);
                        break;
                    case 2:
                        NewUserUI newUserUI = new NewUserUI();
                        UserResisterController userResisterController = new UserResisterController(users);
                        newUserUI.RegisterUser(userResisterController);
                        urw.saveToFile(filepath, users);
                        break;
                    default:
                        System.out.println("Invalid input, please try again.");
                }

            } catch (InputMismatchException e){
                System.out.println("Invalid input, please try again. \n");
                input.nextLine();
            }catch (EOFException eofException){
                System.out.println("eofException");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.out.println("ioException");
            } catch (ClassNotFoundException classNotFoundException) {
                System.out.println("classNotFoundException");
            }
        }
    }
}
