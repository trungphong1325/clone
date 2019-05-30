package com.treeforcom.clone.view.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.treeforcom.clone.R;
import com.treeforcom.clone.data.ResourceModel;
import com.treeforcom.clone.data.remote.request.login.LoginParam;
import com.treeforcom.clone.data.remote.response.login.UserResponse;
import com.treeforcom.clone.factory.ViewModelFactory;
import com.treeforcom.clone.view.home.HomeActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class LoginActivity extends AppCompatActivity {
    Button buttonLogin;
    EditText editTextEmail;
    EditText editTextPass;
    ProgressBar indicator;
    @Inject
    ViewModelFactory modelFactory;

    private LoginViewModel viewModel;
    final Boolean[] emailChecking = {false};
    final Boolean[] passwordChecking = {false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_login);
        mapperView();
        initializeView();
        initializeListener();
        initializeViewModel();
    }

    private void initializeView() {
        observableEditTextListener();
    }

    private void initializeListener() {
        buttonLogin.setOnClickListener(v -> {
            indicator.setVisibility(View.VISIBLE);
            viewModel.authenticate(new LoginParam(
                    editTextEmail.getText().toString(),
                    editTextPass.getText().toString())
            );
        });
    }

    private void mapperView() {
        buttonLogin = findViewById(R.id.login);
        editTextEmail = findViewById(R.id.email);
        editTextPass = findViewById(R.id.password);
        indicator = findViewById(R.id.indicator);
    }

    private void observableEditTextListener() {
        RxTextView.textChangeEvents(editTextEmail).subscribe(email -> {
            emailChecking[0] = Patterns.EMAIL_ADDRESS.matcher(email.text().toString().trim()).matches();
            checkEnable();
        });
        RxTextView.textChangeEvents(editTextPass).subscribe(password -> {
            passwordChecking[0] = password.text().toString().length() > 5;
            checkEnable();
        });
    }

    private void checkEnable() {
        buttonLogin.setEnabled(emailChecking[0] && passwordChecking[0]);
    }

    private void initializeViewModel() {
        viewModel = ViewModelProviders.of(this, modelFactory).get(LoginViewModel.class);
        viewModel.userResponseLiveData().observe(LoginActivity.this, this::render);
    }

    private void render(ResourceModel<UserResponse> resource) {
        switch (resource.statusModel) {
            case LOADING: {
                indicator.setVisibility(View.VISIBLE);

                break;
            }
            case SUCCESS: {
                indicator.setVisibility(View.GONE);
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                break;
            }
            case ERROR: {
                indicator.setVisibility(View.GONE);

                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
