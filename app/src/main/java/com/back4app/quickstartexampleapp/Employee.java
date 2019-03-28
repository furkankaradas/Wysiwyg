package com.back4app.quickstartexampleapp;

import java.util.Arrays;

public class Employee {

    private String firstName;
    private String lastName;
    private String eMail;
    private String[] gender = {
            "Man", "Woman"
    };
    private String birth;
    private int turkishIdentifier;
    private int phoneNumber;
    private String[] drivingLicense = {
            "A", "B", "C", "D", "E"
    };
    private String[] bloodType = {
            "A Rh+", "A Rh-",
            "B Rh+", "B Rh-",
            "AB Rh+", "AB Rh-",
            "0 Rh+", "0 Rh-"
    };

    public Employee(String firstName, String lastName, String eMail, String[] gender,
                    String birth, int turkishIdentifier, int phoneNumber,
                    String[] drivingLicense, String[] bloodType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.gender = gender;
        this.birth = birth;
        this.turkishIdentifier = turkishIdentifier;
        this.phoneNumber = phoneNumber;
        this.drivingLicense = drivingLicense;
        this.bloodType = bloodType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String[] getGender() {
        return gender;
    }

    public void setGender(String[] gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getTurkishIdentifier() {
        return turkishIdentifier;
    }

    public void setTurkishIdentifier(int turkishIdentifier) {
        this.turkishIdentifier = turkishIdentifier;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String[] getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String[] drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String[] getBloodType() {
        return bloodType;
    }

    public void setBloodType(String[] bloodType) {
        this.bloodType = bloodType;
    }

    //Display function
    @Override
    public String toString() {
        return  "First Name:" + firstName + '\n' +
                "Last Name:" + lastName + '\n' +
                "E-Mail:" + eMail + '\n' +
                "Gender:" + Arrays.toString(gender) + '\n' +
                "Birth Date:" + birth + '\n' +
                "Turkish Identifier:" + turkishIdentifier + '\n' +
                "Phone Number:" + phoneNumber + '\n' +
                "Driving License:" + Arrays.toString(drivingLicense) + '\n' +
                "Blood Type:" + Arrays.toString(bloodType) + '\n';
    }

    public void deleteAccount() {

    }

    public void updateAccount(String firstName, String lastName, String eMail, String[] gender,
                              String birth, int turkishIdentifier, int phoneNumber,
                              String[] drivingLicense, String[] bloodType) {


    }

}
