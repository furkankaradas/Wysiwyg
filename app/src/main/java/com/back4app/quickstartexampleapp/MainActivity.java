package com.back4app.quickstartexampleapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseInstallation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button signInButton;
    private Button logInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.signInButton);
        signInButton.setOnClickListener(this);
        logInButton = findViewById(R.id.logInButton);
        logInButton.setOnClickListener(this);

        // Save the current Installation to Back4App
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

    @Override
    public void onClick(View view) {
        if(view == signInButton) {
            Intent signInIntent = new Intent(this, activity_signIn.class);
            startActivity(signInIntent);
        }
        if(view == logInButton) {
            Intent signInIntent = new Intent(this, activity_logIn.class);
            startActivity(signInIntent);
        }
    }
}