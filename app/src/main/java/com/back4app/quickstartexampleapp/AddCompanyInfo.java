package com.back4app.quickstartexampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class AddCompanyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company_info);
        final EditText compName=findViewById(R.id.editTextCompName);
        final EditText compAddress=findViewById(R.id.editTextAddress);
        final EditText compTax=findViewById(R.id.editTextTax);
        final EditText compPhone=findViewById(R.id.editTextCompPhone);
        Button save =findViewById(R.id.buttonSubmit2);

        final Company company=new Company();
        final ParseObject companyParse=new ParseObject("Company");
        Intent intent2 = getIntent();
        Bundle extras2 = intent2.getExtras();
        final String username= extras2.getString("username");
        final String password=extras2.getString("password");
       final String email=extras2.getString("email");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                company.setAddress(compAddress.getText().toString());
                company.setEmail(email);
                company.setName(compName.getText().toString());
                company.setPhoneNumber(compPhone.getText().toString());
                company.setScore(0);
                company.setTaxID(compTax.getText().toString());
                company.setUsername(username);
                company.setPassword(password);


                companyParse.put("username",company.getUsername());
                companyParse.put("password",company.getPassword());
                companyParse.put("email",company.getEmail());
                companyParse.put("name",company.getName());
                companyParse.put("score",company.getScore());
            companyParse.put("taxNumber",company.getTaxID());
            companyParse.put("address",company.getAddress());
            companyParse.put("phoneNumber",company.getPhoneNumber());
            companyParse.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e==null)
                    {
                        Toast.makeText(getApplicationContext(),"Saved successfully.",Toast.LENGTH_SHORT).show();
                        Intent intent1 =new Intent(AddCompanyInfo.this, LoginActivity.class);
                        startActivity(intent1);

                    }
                    else
                        Toast.makeText(getApplicationContext(),"Error.",Toast.LENGTH_SHORT).show();

                }
            });


            }
        });

    }
}
