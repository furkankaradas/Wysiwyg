package com.back4app.quickstartexampleapp;

public class User {
    private String username;
    private String email;
    private String password;
    public User(){}
    public User(String _username,String _email,String _password)
    {
        this.username=_username;
        this.email=_email;
        this.password=_password;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
