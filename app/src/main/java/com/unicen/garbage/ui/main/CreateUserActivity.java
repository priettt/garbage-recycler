package com.unicen.garbage.ui.main;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.unicen.garbage.R;
import com.unicen.garbage.domain.RecyclingRepository;
import com.unicen.garbage.domain.entities.User;

public class CreateUserActivity extends AppCompatActivity {

    private TextInputEditText firstNameText;
    private TextInputEditText lastNameText;
    private TextInputEditText emailText;
    private TextInputEditText usernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        firstNameText = findViewById(R.id.create_user_first_name_field);
        lastNameText = findViewById(R.id.create_user_last_name_field);
        emailText = findViewById(R.id.create_user_email_field);
        usernameText = findViewById(R.id.create_user_username_field);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(this.getResources().getString(R.string.create_user_title));
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }

        Button submitButton = findViewById(R.id.create_user_submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (firstNameText.getText() != null && lastNameText.getText() != null && emailText.getText() != null
                        && usernameText.getText() != null && !usernameText.getText().toString().isEmpty()) {
                    RecyclingRepository.createNewUser(getApplicationContext(), new User(firstNameText.getText().toString(),
                            lastNameText.getText().toString(), emailText.getText().toString(), usernameText.getText().toString()));
                }
            }
        });
    }

    @Override public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
