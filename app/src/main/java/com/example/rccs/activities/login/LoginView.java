package com.example.rccs.activities.login;

public interface LoginView {
    void loginSuccess();

    void loginFail(String msg);

    void getAllDataSuccess();

    void getAllDataFail(String msg);
}
