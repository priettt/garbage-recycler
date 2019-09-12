package com.unicen.garbage.ui.main;

import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.unicen.garbage.R;
import com.unicen.garbage.domain.RecyclingRepository;
import com.unicen.garbage.domain.entities.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserActivity extends AppCompatActivity {

    private TextInputEditText firstNameText;
    private TextInputEditText lastNameText;
    private TextInputEditText emailText;
    private TextInputEditText usernameText;
    private TextInputEditText addressText;
    private final static int NOT_ACCEPTABLE = 406;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        firstNameText = findViewById(R.id.create_user_first_name_field);
        lastNameText = findViewById(R.id.create_user_last_name_field);
        emailText = findViewById(R.id.create_user_email_field);
        usernameText = findViewById(R.id.create_user_username_field);
        addressText = findViewById(R.id.create_user_address_field);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(this.getResources().getString(R.string.create_user_title));
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }

        Button submitButton = findViewById(R.id.create_user_submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstNameText.getText() != null && lastNameText.getText() != null && emailText.getText() != null &&
                        usernameText.getText() != null && addressText.getText() != null && !usernameText.getText().toString().isEmpty()) {
                    Call<User> userCall = RecyclingRepository.saveUserInServer(new User(firstNameText.getText().toString(),
                            lastNameText.getText().toString(), emailText.getText().toString(), usernameText.getText().toString(),
                            addressText.getText().toString()));

                    userCall.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                RecyclingRepository.saveUserInPreferences(response.body(), getApplicationContext());
                                Toast.makeText(getApplicationContext(), "User succesfully created", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                if (response.code() == NOT_ACCEPTABLE)
                                    showErrorAlreadyRegistered();
                                else
                                    showError();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            showError();
                        }
                    });
                } else {
                    showError();
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void showError() {
        Toast.makeText(CreateUserActivity.this, "Something went wrong, try again!", Toast.LENGTH_SHORT).show();
    }

    private void showErrorAlreadyRegistered() {
        Toast.makeText(CreateUserActivity.this, "That username is already in use", Toast.LENGTH_SHORT).show();
    }
}