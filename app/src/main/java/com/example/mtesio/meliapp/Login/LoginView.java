package com.example.mtesio.meliapp.Login;

public interface LoginView {

    boolean areFieldsEmpty();

    void navigateToNextPage();

    String getUsername();

    String getPassword();
}
