package com.back4app.quickstartexampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EmployeeProfil extends AppCompatActivity {
    private ImageView img;
    private String userObjectID = "vJp0QdSnil";
    private SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_profil);

        Employee userInfo = new Employee();

        try {
            userInfo = exportData();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        img = findViewById(R.id.imageField);
        img.setImageResource(R.drawable.avatar);
        TextView nameField = findViewById(R.id.CnameField);
        TextView surnameField = findViewById(R.id.surnameField);
        TextView emailField = findViewById(R.id.CemailField);
        TextView idField = findViewById(R.id.CtaxField);
        TextView birthField = findViewById(R.id.CAddressField);
        TextView drivingField = findViewById(R.id.dlField);
        TextView bloodField = findViewById(R.id.bloodGroupField);
        TextView phoneField = findViewById(R.id.phoneField);
        TextView genderField = findViewById(R.id.genderField);

        nameField.setText("Name: " + userInfo.getFirstName());
        surnameField.setText("Surname: "+ userInfo.getLastName());
        emailField.setText("E-mail: " + userInfo.geteMail());
        idField.setText("ID: " + userInfo.getTurkishIdentifier());
        birthField.setText("Birth Date: " + ft.format(userInfo.getBirth()));
        drivingField.setText("Driving License: " + userInfo.getDrivingLicense());
        bloodField.setText("Blood Type: " + userInfo.getBloodType());
        phoneField.setText("Phone: " + userInfo.getPhoneNumber());
        genderField.setText("Gender: " + userInfo.getGender());


    }

    private void importData() {
        ParseObject entity = new ParseObject("Employee");

        entity.put("name", "Furkan");
        entity.put("surname", "Karadaş");
        entity.put("email", "karadasfurkan@yandex.com");
        entity.put("password", "123");
        entity.put("birthDate", new Date());
        entity.put("idNumber", "12384256978");
        entity.put("phone", "5358629282");
        entity.put("bloodType", "A RH+");
        entity.put("drivingLicense", "B");
        entity.put("gender", "Man");

        // Saves the new object.
        // Notice that the SaveCallback is totally optional!
        entity.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                // Here you can handle errors, if thrown. Otherwise, "e" should be null
            }
        });
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
                user.setBirth(object.getString("birthDate"));
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
