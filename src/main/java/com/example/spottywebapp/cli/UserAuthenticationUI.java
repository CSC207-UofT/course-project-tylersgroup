package com.example.spottywebapp.cli;


import com.example.spottywebapp.Controllers.LoginController;
import com.example.spottywebapp.Controllers.UserResisterController;
import com.example.spottywebapp.UseCases.LoginUseCase;
import com.example.spottywebapp.Controllers.UserReadWriter;
import com.example.spottywebapp.entities.UserList;

import java.io.EOFException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


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
                String usersData = "users_data.ser";
                UserReadWriter urw = new UserReadWriter();
                UserList users = urw.readFromFile(usersData);
                switch (numIn) {
                    case 1:
                        LoginUI loginUI = new LoginUI();
                        LoginUseCase useCase = new LoginUseCase(urw, users);
                        LoginController controller = new LoginController(useCase);
                        System.out.println(users.toString());
                        loginUI.runLogin(controller);
                        break;
                    case 2:
                        NewUserUI newUserUI = new NewUserUI();
                        UserResisterController userResisterController = new UserResisterController(users);
                        newUserUI.RegisterUser(userResisterController);
                        System.out.println(users.toString());
                        urw.saveToFile(usersData, users);
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
            }
        }
    }
}
