package com.back4app.quickstartexampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.parse.ParseUser;

public class Register extends AppCompatActivity {

    private ParseUser user = new ParseUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText _username = findViewById(R.id.editTextUsername);
        final EditText _email = findViewById(R.id.editTextEmail);
        final EditText _password = findViewById(R.id.editTextPassword);
        Button signUpButtonCompany = findViewById(R.id.registerCompany);
        Button signUpButtonUser = findViewById(R.id.registerUser);
        final Bundle userInfo = new Bundle();


        signUpButtonCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User newUSer = new User();
                Intent intentCompany = new Intent(Register.this, AddCompanyInfo.class);

                newUSer.setEmail(String.valueOf(_email.getText()));
                newUSer.setUsername(String.valueOf(_username.getText()));
                newUSer.setPassword(String.valueOf(_password.getText()));
                user.setEmail(newUSer.getEmail());
                user.setPassword(newUSer.getEmail());
                user.setUsername(newUSer.getUsername());
                user.put("isCompany", true);
                user.signUpInBackground();
                userInfo.putString("username", newUSer.getUsername());
                userInfo.putString("email", newUSer.getEmail());
                userInfo.putString("password", newUSer.getPassword());
                intentCompany.putExtras(userInfo);
                startActivity(intentCompany);
            }
        });
        signUpButtonUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User newUSer2 = new User();
                Intent intentEmployee = new Intent(Register.this, AddEmployeeInfo.class);

                newUSer2.setEmail(String.valueOf(_email.getText()));
                newUSer2.setUsername(String.valueOf(_username.getText()));
                newUSer2.setPassword(String.valueOf(_password.getText()));
                user.setEmail(newUSer2.getEmail());
                user.setPassword(newUSer2.getEmail());
                user.setUsername(newUSer2.getUsername());
                user.put("isCompany", false);
                user.signUpInBackground();
                userInfo.putString("username", newUSer2.getUsername());
                userInfo.putString("email", newUSer2.getEmail());
                userInfo.putString("password", newUSer2.getPassword());
                intentEmployee.putExtras(userInfo);
                startActivity(intentEmployee);
            }
        });


    }


}
