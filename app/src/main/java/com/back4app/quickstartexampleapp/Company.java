package com.back4app.quickstartexampleapp;

public class Company {

    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String taxID;
    private int score;
    private String username;
    private String password;

    public Company() {
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
        this.email = "";
        this.taxID = "";
        this.score = 0;
        this.password="";
        this.username="";
    }

    public Company(String name, String address, String phoneNumber,
                   String email, String taxID, int score, String username, String password) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.taxID = taxID;
        this.score = score;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", taxID='" + taxID + '\'' +
                ", score=" + score +
                '}';
    }
}
