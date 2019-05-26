package com.back4app.quickstartexampleapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameView;
    private EditText passwordView;
    Boolean iscomp;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameView = (EditText) findViewById(R.id.username_text);
        passwordView = (EditText) findViewById(R.id.password_text);
        pref = getSharedPreferences("sessionID",MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        final Button login_button = findViewById(R.id.button);
        final Button reg_button = findViewById(R.id.registerButton);

        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regIntent = new Intent(LoginActivity.this, Register.class);
                startActivity(regIntent);
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dlg = new ProgressDialog(LoginActivity.this);
                dlg.setTitle("Please, wait a moment.");
                dlg.setMessage("Logging in...");
                dlg.show();

                ParseUser.logInInBackground(usernameView.getText().toString(), passwordView.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser != null) {
                            dlg.dismiss();
                            iscomp=parseUser.getBoolean("isCompany");
                            editor.putString("objectID", parseUser.getString("username"));
                            editor.commit();
                            if(iscomp.equals(true) ) {
                                Intent hellocompany = new Intent(LoginActivity.this, CompanyScreen.class);
                                startActivity(hellocompany);
                            }
                            else{
                                Intent helloemployee = new Intent(LoginActivity.this, EmployeeScreen.class);
                                startActivity(helloemployee);

                            }
                        } else {
                            dlg.dismiss();
                            ParseUser.logOut();
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }

}
