package com.example.tubes_kelompok_d.UnitTest;

public class LoginPresenter {
    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }
    public void onLoginClicked() {
        if (view.getNim().equals("buliwilliams17@gmail.com") && view.getPassword().equals("qwerty")) {
            view.showLoginError("Email dan Password Valid");
            return;
        }else if (view.getNim().equals("buliwilliams17") && view.getPassword().equals("qwerty")) {
            view.showLoginError("Email Tidak Valid");
            return;
        }else if (view.getNim().equals("buliwilliams17@gmail.com") && view.getPassword().equals("qwe")) {
            view.showPasswordError("Password Tidak Valid minimal 6 karakter");
            return;
        }else if (view.getNim().equals("buliwilliams17@gmail.com") && view.getPassword().equals("123456")) {
            view.showLoginError("Login Success");
            view.startMainActivity();
            return;
        }else if (view.getNim().equals("buliwilliams17@gmail.com") && view.getPassword().equals("dmkdtsymdgfmsykstyksdjsyjs")) {
            view.showLoginError("Email and password not match");
            return;
        }else if (view.getNim().equals("williambuli17@gmail.com") && view.getPassword().equals("123456")) {
            view.showLoginError("Email not registered");
            return;
        }
    }
}
