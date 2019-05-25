package com.back4app.quickstartexampleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.SimpleDateFormat;
import java.util.List;


public class EmployeeProfileFragment extends Fragment {

    private View view;
    private ImageView img;
    private String userObjectID = "vJp0QdSnil";
    private SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm");


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_employee_profile, null);

        Employee userInfo = new Employee();

        try {
            userInfo = exportData();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        img = view.findViewById(R.id.imageField);
        img.setImageResource(R.drawable.avatar);
        TextView nameField = view.findViewById(R.id.CnameField);
        TextView surnameField = view.findViewById(R.id.surnameField);
        TextView emailField = view.findViewById(R.id.CemailField);
        TextView idField = view.findViewById(R.id.CtaxField);
        TextView birthField = view.findViewById(R.id.BirthDateField);
        TextView drivingField = view.findViewById(R.id.dlField);
        TextView bloodField = view.findViewById(R.id.bloodGroupField);
        TextView phoneField = view.findViewById(R.id.phoneField);
        TextView genderField = view.findViewById(R.id.genderField);

        nameField.setText("Name: " + userInfo.getFirstName());
        surnameField.setText("Surname: "+ userInfo.getLastName());
        emailField.setText("E-mail: " + userInfo.geteMail());
        idField.setText("ID: " + userInfo.getTurkishIdentifier());
        birthField.setText("Birth Date: " + ft.format(userInfo.getBirth()));
        drivingField.setText("Driving License: " + userInfo.getDrivingLicense());
        bloodField.setText("Blood Type: " + userInfo.getGender());
        phoneField.setText("Phone: " + userInfo.getPhoneNumber());
        genderField.setText("Gender: " + userInfo.getGender());

        return view;
    }

    private Employee exportData() throws ParseException {
        Employee user = new Employee();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Employee");
        query.whereEqualTo("objectId", userObjectID);
        List<ParseObject> parseObjects = query.find();
        if (parseObjects.size() == 0)
            return null;
        else {
            for (ParseObject object : parseObjects) {
                user.setFirstName(object.getString("name"));
                user.setLastName(object.getString("surname"));
                user.seteMail(object.getString("email"));
                user.setBirth(object.getDate("birthDate"));
                user.setTurkishIdentifier(object.getString("idNumber"));
                user.setPhoneNumber(object.getString("phone"));
                user.setBloodType(object.getString("bloodType"));
                user.setDrivingLicense(object.getString("drivingLicense"));
                user.setGender(object.getString("gender"));

            }
        }
        return user;

    }
}
