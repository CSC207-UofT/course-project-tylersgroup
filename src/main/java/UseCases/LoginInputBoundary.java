package UseCases;

public interface LoginInputBoundary {
    LoginUseCase.LoginResult logIn(String username, String password);
}
