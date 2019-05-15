package com.back4app.quickstartexampleapp;

import java.util.Date;

public class Employee {

    private String firstName;
    private String lastName;
    private String eMail;
    private String gender;
    private Date birth;
    private String turkishIdentifier;
    private String phoneNumber;
    private String drivingLicense;
    private String bloodType;

    public Employee() {
        firstName = "";
        lastName = "";
        eMail = "";
        gender = "";
        birth = new Date();
        turkishIdentifier = "";
        phoneNumber = "";
        drivingLicense = "";
        bloodType = "";
    }

    public Employee(String firstName, String lastName, String eMail, String gender,
                    Date birth, String turkishIdentifier, String phoneNumber, String drivingLicense, String bloodType) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getTurkishIdentifier() {
        return turkishIdentifier;
    }

    public void setTurkishIdentifier(String turkishIdentifier) {
        this.turkishIdentifier = turkishIdentifier;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                ", turkishIdentifier=" + turkishIdentifier +
                ", phoneNumber=" + phoneNumber +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }
}
