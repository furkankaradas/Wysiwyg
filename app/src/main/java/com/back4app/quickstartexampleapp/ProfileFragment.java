package com.back4app.quickstartexampleapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class ProfileFragment extends Fragment {
    private ImageView img;
    private String companyObjectID = "";
    private View view;
    SharedPreferences prf;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, null);

        prf = getActivity().getApplicationContext().getSharedPreferences("sessionID", Context.MODE_PRIVATE);
        companyObjectID = prf.getString("objectID", null);

        Company company = null;
        try {
            company = export();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        img = view.findViewById(R.id.imageField);
        img.setImageResource(R.drawable.avatar);

        TextView nameField = view.findViewById(R.id.CnameField);
        TextView phoneField = view.findViewById(R.id.CPhoneField);
        TextView addressField = view.findViewById(R.id.CAddressField);
        TextView emailField = view.findViewById(R.id.CemailField);
        TextView taxID = view.findViewById(R.id.CtaxField);
        TextView score = view.findViewById(R.id.CScoreField);

        nameField.setText("Name: " + company.getName());
        phoneField.setText("Phone: " + company.getPhoneNumber());
        addressField.setText("Address: " + company.getAddress());
        emailField.setText("Email: " + company.getEmail());
        taxID.setText("Tax Number: " + company.getTaxID());
        score.setText("Score: " + Integer.toString(company.getScore()));

        return view;
    }

    private Company export() throws ParseException {
        Company company = new Company();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Company");
        query.whereEqualTo("username", companyObjectID);
        List<ParseObject> parseObjects = query.find();
        if (parseObjects.size() != 0)
        {
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
}

