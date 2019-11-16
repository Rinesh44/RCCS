package com.example.rccs.activities.login;

import com.example.rccs.api.Endpoints;

public class LoginPresenterImpl implements LoginPresenter {
    private LoginActivity activity;
    private Endpoints endpoints;

    public LoginPresenterImpl(LoginActivity activity, Endpoints endpoints) {
        this.activity = activity;
        this.endpoints = endpoints;
    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public void getAllData(String token) {

    }
}
