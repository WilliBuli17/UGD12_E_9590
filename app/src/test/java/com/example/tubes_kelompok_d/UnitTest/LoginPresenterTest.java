package com.example.tubes_kelompok_d.UnitTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Mock
    private LoginView view;
    private LoginPresenter presenter;
    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view);
    }
    @Test
    public void Login1() throws Exception {
        when(view.getNim()).thenReturn("buliwilliams17@gmail.com");
        System.out.println("nim : "+view.getNim());
        when(view.getPassword()).thenReturn("qwerty");
        System.out.println("password : "+view.getPassword());
        presenter.onLoginClicked();
        verify(view).showLoginError("Email dan Password Valid");
    }
    @Test
    public void Login2() throws Exception {
        when(view.getNim()).thenReturn("buliwilliams17");
        System.out.println("nim : "+view.getNim());
        when(view.getPassword()).thenReturn("qwerty");
        System.out.println("password : "+view.getPassword());
        presenter.onLoginClicked();
        verify(view).showLoginError("Email Tidak Valid");
    }
    @Test
    public void Login3() throws Exception {
        when(view.getNim()).thenReturn("buliwilliams17@gmail.com");
        System.out.println("nim : "+view.getNim());
        when(view.getPassword()).thenReturn("qwe");
        System.out.println("password : "+view.getPassword());
        presenter.onLoginClicked();
        verify(view).showPasswordError("Password Tidak Valid minimal 6 karakter");
    }
    @Test
    public void Login4() throws Exception {
        when(view.getNim()).thenReturn("buliwilliams17@gmail.com");
        System.out.println("nim : "+view.getNim());
        when(view.getPassword()).thenReturn("123456");
        System.out.println("password : "+view.getPassword());
        presenter.onLoginClicked();
        verify(view).showLoginError("Login Success");
        verify(view).startMainActivity();
    }
    @Test
    public void Login5() throws Exception {
        when(view.getNim()).thenReturn("buliwilliams17@gmail.com");
        System.out.println("nim : "+view.getNim());
        when(view.getPassword()).thenReturn("dmkdtsymdgfmsykstyksdjsyjs");
        System.out.println("password : "+view.getPassword());
        presenter.onLoginClicked();
        verify(view).showLoginError("Email and password not match");
    }
    @Test
    public void Login6() throws Exception {
        when(view.getNim()).thenReturn("williambuli17@gmail.com");
        System.out.println("nim : "+view.getNim());
        when(view.getPassword()).thenReturn("123456");
        System.out.println("password : "+view.getPassword());
        presenter.onLoginClicked();
        verify(view).showLoginError("Email not registered");
    }
}