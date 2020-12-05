package com.example.tubes_kelompok_d.UnitTest;

public interface LoginView {
    String getNim();

    void showNimError(String message);

    String getPassword();

    void showPasswordError(String message);

    void startMainActivity();

    void showLoginError(String message);

    void showErrorResponse(String message);
}

