package com.back4app.quickstartexampleapp;

import java.util.Date;

public class Employee {

    private String firstName;
    private String lastName;
    private String eMail;
    private String gender;
    private String birth;
    private String turkishIdentifier;
    private String phoneNumber;
    private String drivingLicense;
    private String bloodType;
    private String workDate;
    private String workHour;
    private String username;
    private String password;

    public Employee() {
        firstName = "";
        lastName = "";
        eMail = "";
        gender = "";
        birth = "";
        turkishIdentifier = "";
        phoneNumber = "";
        drivingLicense = "";
        bloodType = "";
        workDate = "";
        workHour = "";
        username="";
        password="" ;
    }

    public Employee(String firstName, String lastName, String eMail, String gender,
                    String birth, String turkishIdentifier, String phoneNumber, String drivingLicense,
                    String bloodType, String workDate, String workHour, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.gender = gender;
        this.birth = birth;
        this.turkishIdentifier = turkishIdentifier;
        this.phoneNumber = phoneNumber;
        this.drivingLicense = drivingLicense;
        this.bloodType = bloodType;
        this.workDate = workDate;
        this.workHour = workHour;
        this.username = username;
        this.password = password;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
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

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getWorkHour() {
        return workHour;
    }

    public void setWorkHour(String workHour) {
        this.workHour = workHour;
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
