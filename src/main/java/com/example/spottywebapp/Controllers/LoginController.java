package com.example.spottywebapp.Controllers;

import com.example.spottywebapp.UseCases.LoginInputBoundary;
import com.example.spottywebapp.UseCases.LoginUseCase;
import com.example.spottywebapp.entities.UserList;

public class LoginController {

    /**
     * The input boundary for the login use case.
     */
    private final LoginInputBoundary loginInputBoundary;

    /**
     * / The "output" of this controller.
     */
    public enum LoginControllerResult {
        SUCCESS, FAILURE, NO_SUCH_USER
    }

    /**
     * A new LoginController for the use case defined by the LoginInputBoundary.
     * @param loginInputBoundary the input boundary for the login use case
     */
    public LoginController(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }

    /**
     * Run the login use case where username is attempting to log into their
     * account with a password attempt.
     * @param username the username
     * @param password the password attempt
     * @return whether the login was success, failure, or no_such_user
     */
    public LoginControllerResult runLogin(String username, String password) {
        // hands off the work to the use case class.
        LoginUseCase.LoginResult result = loginInputBoundary.logIn(username, password);
        switch (result) {
            case SUCCESS:
                return LoginControllerResult.SUCCESS;
            case FAILURE:
                return LoginControllerResult.FAILURE;
            case NO_SUCH_USER:
                return LoginControllerResult.NO_SUCH_USER;

        }
        //TODO: why do we have to return null?
        return null;
    }

}
