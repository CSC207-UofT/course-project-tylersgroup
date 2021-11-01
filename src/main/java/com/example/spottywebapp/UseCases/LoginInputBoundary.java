package com.example.spottywebapp.UseCases;

public interface LoginInputBoundary {
    UseCases.LoginUseCase.LoginResult logIn(String username, String password);
}
