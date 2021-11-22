package com.example.spottyv2.UseCases;

public interface LoginInputBoundary {
    LoginUseCase.LoginResult logIn(String username, String password);
}
