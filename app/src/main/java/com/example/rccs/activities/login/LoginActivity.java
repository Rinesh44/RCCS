package com.example.rccs.activities.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.example.rccs.R;
import com.example.rccs.activities.ReportsActivity;
import com.example.rccs.activities.base.BaseActivity;
import com.example.rccs.api.Endpoints;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.rccs.RccsApp.getMyApplication;

public class LoginActivity extends BaseActivity implements LoginView {
    private static final String TAG = "LoginActivity";
    @Inject
    Endpoints endpoints;
    @BindView(R.id.il_username)
    TextInputLayout mUsernameLayout;
    @BindView(R.id.et_username)
    TextInputEditText mUsername;
    @BindView(R.id.il_password)
    TextInputLayout mPasswordLayout;
    @BindView(R.id.et_password)
    TextInputEditText mPassword;
    @BindView(R.id.btn_login)
    MaterialButton mLogin;

    private LoginPresenter presenter;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_for_keyboard_glitch));
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        getMyApplication(this).getAppComponent().inject(this);

        presenter = new LoginPresenterImpl(this, endpoints);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                validateAndLogin();
                startActivity(new Intent(LoginActivity.this, ReportsActivity.class));
            }
        });

    }

    private void validateAndLogin() {
        if (Objects.requireNonNull(mUsername.getText()).toString().isEmpty()) {
            mUsernameLayout.setErrorEnabled(true);
            mUsernameLayout.setError("This field is required");
            mUsername.requestFocus();
            return;
        } else {
            mUsernameLayout.setErrorEnabled(false);
        }

        if (Objects.requireNonNull(mPassword.getText()).toString().isEmpty()) {
            mPasswordLayout.setErrorEnabled(true);
            mPasswordLayout.setError("This field is required");
            mPassword.requestFocus();
            return;
        } else {
            mPasswordLayout.setErrorEnabled(false);
        }

        showLoading();

        presenter.login(mUsername.getText().toString().trim(), mPassword.getText().toString().trim());
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFail(String msg) {
        showMessage(msg);
    }

    @Override
    public void getAllDataSuccess() {

    }

    @Override
    public void getAllDataFail(String msg) {
        showMessage(msg);
    }
}
