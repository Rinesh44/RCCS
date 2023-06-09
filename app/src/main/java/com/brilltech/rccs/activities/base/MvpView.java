package com.brilltech.rccs.activities.base;

public interface MvpView {
    void showKeyboard();

    void hideKeyboard();

    void showLoading();

    void hideLoading();

    void showMessage(String message);
}
