package com.back4app.quickstartexampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.text.SimpleDateFormat;


public class AddEmployeeInfo extends AppCompatActivity {

    private SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_info);
        Button submitForm =findViewById(R.id.buttonSubmit);
        final EditText name=findViewById(R.id.editTextCompName);
        final EditText surname=findViewById(R.id.editTextSurname);
        final EditText tc=findViewById(R.id.editTextTC);
        final EditText drivingLicence=findViewById(R.id.editTextDrivingLicence);
        final EditText bloodType=findViewById(R.id.editTextBloodType);
        final EditText gender=findViewById(R.id.editTextGender);
        final EditText workDate=findViewById(R.id.editTextWorkDate);
        final EditText workHour=findViewById(R.id.editTextHour);
        final EditText phoneNumber=findViewById(R.id.editTextPhoneNumber);
        final EditText birthDate =findViewById(R.id.editTextBirthdate);
        final Employee employee=new Employee();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final String register_username=extras.getString("username");
        final String register_email=extras.getString("email");
        final String register_password=extras.getString("password");
        final ParseObject newEmployee=new ParseObject("Employee");
        submitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employee.setFirstName(name.getText().toString());
                employee.setLastName(surname.getText().toString());
                employee.setBloodType(bloodType.getText().toString());
                employee.setBirth(birthDate.getText().toString());
                employee.setDrivingLicense(drivingLicence.getText().toString());
                employee.setTurkishIdentifier(tc.getText().toString());
                employee.setGender(gender.getText().toString());
                employee.setWorkDate(workDate.getText().toString());
                employee.setWorkHour(workDate.getText().toString());
                employee.setPhoneNumber(phoneNumber.getText().toString());
                employee.seteMail(register_email);
                employee.setUsername(register_username);
                employee.setPassword(register_password);


                newEmployee.put("username",employee.getUsername());
                newEmployee.put("password",employee.getPassword());
                newEmployee.put("gender",employee.getGender());
                newEmployee.put("idNumber",employee.getTurkishIdentifier());
                newEmployee.put("name",employee.getFirstName());
                newEmployee.put("birthDate",employee.getBirth());
                newEmployee.put("phone",employee.getPhoneNumber());
                newEmployee.put("bloodType",employee.getBloodType());
                newEmployee.put("email",employee.geteMail());
                newEmployee.put("surname",employee.getLastName());
                newEmployee.put("drivingLicense",employee.getDrivingLicense() );
                newEmployee.put("workHour",employee.getWorkHour());
                newEmployee.put("workDate",employee.getWorkDate());

                String eDate = String.valueOf(workDate.getText()) + " " + String.valueOf(workHour.getText());
                try {
                    newEmployee.put("wDate", ft.parse(eDate));
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
                newEmployee.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null)
                        {
                            Toast.makeText(getApplicationContext(),"Saved successfully.",Toast.LENGTH_SHORT).show();
                            Intent intent1 =new Intent(AddEmployeeInfo.this, LoginActivity.class);
                            startActivity(intent1);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Error.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
    }








}
