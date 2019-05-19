package com.back4app.quickstartexampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class CompanyProfile extends AppCompatActivity {

    private ImageView img;
    private String companyObjectID = "yex8kVP2jj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_profile);

        img = findViewById(R.id.imageField);
        img.setImageResource(R.drawable.avatar);

        TextView nameField = findViewById(R.id.CnameField);
        TextView phoneField = findViewById(R.id.CPhoneField);
        TextView addressField = findViewById(R.id.CAddressField);
        TextView emailField = findViewById(R.id.CemailField);
        TextView taxID = findViewById(R.id.CtaxField);
        TextView score = findViewById(R.id.CScoreField);


        Company company = new Company();

        try {
            company = exportData();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        nameField.setText("Name: " + company.getName());
        phoneField.setText("Phone: " + company.getPhoneNumber());
        addressField.setText("Address: " + company.getAddress());
        emailField.setText("Email: " + company.getEmail());
        taxID.setText("Tax Number: " + company.getTaxID());
        score.setText("Score: " + Integer.toString(company.getScore()));

    }

    private Company exportData() throws ParseException {
        Company company = new Company();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Company");
        query.whereEqualTo("objectId", companyObjectID);
        List<ParseObject> parseObjects = query.find();
        if (parseObjects.size() == 0)
            return null;
        else {
            for (ParseObject object : parseObjects) {
                company.setName(object.getString("name"));
                company.setAddress(object.getString("address"));
                company.setEmail(object.getString("email"));
                company.setPhoneNumber(object.getString("phoneNumber"));
                company.setTaxID(object.getString("taxNumber"));
                company.setScore(object.getInt("score"));
            }
        }
        return company;

    }


    private void addCompanyInfo() {
        ParseObject entity = new ParseObject("Company");

        entity.put("name", "TAI");
        entity.put("address", "TUSAŞ AR-GE Binası ODTÜ Teknokent, Ankara");
        entity.put("phoneNumber", "+90 (312) 2101858");
        entity.put("email", "info@tai.com");
        entity.put("taxNumber", "15020053");
        entity.put("score", 10);

        // Saves the new object.
        // Notice that the SaveCallback is totally optional!
        entity.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                // Here you can handle errors, if thrown. Otherwise, "e" should be null
            }
        });
    }
}
