package com.back4app.quickstartexampleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

public class CompanyAddJob extends Fragment {
    private View view;
    private SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm");
    private JSONArray requirements = new JSONArray();
    private ParseObject entity = new ParseObject("Job");
    private String companyObjectID = "yex8kVP2jj";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_company_add_job, null);

        final TextView jobType = view.findViewById(R.id.JobType);
        final TextView jobDefinition = view.findViewById(R.id.JobDefinition);
        final TextView price = view.findViewById(R.id.Price);
        final TextView entryDate = view.findViewById(R.id.EntryDate);
        final TextView entryTime = view.findViewById(R.id.EntryTime);
        final TextView finishDate = view.findViewById(R.id.FinishDate);
        final TextView finishTime = view.findViewById(R.id.FinishTime);
        final TextView req = view.findViewById(R.id.Requirements);
        Button addJobButton = view.findViewById(R.id.addJobButton);

        addJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Job job = new Job();
                    job.setJobType(String.valueOf(jobType.getText()));
                    job.setJobDefinition(String.valueOf(jobDefinition.getText()));
                    job.setFeeInfo(Integer.parseInt(String.valueOf(price.getText())));
                    String eDate = String.valueOf(entryDate.getText()) + " " + String.valueOf(entryTime.getText());
                    job.setEntryDate(ft.parse(eDate));
                    String fDate = String.valueOf(finishDate.getText()) + " " + String.valueOf(finishTime.getText());
                    job.setFinishDate(ft.parse(fDate));
                    requirements.put(new JSONObject().put("Educational Status", String.valueOf(req.getText())));
                    job.setRequirements(requirements);
                    importData(job);
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        return view;
    }

    private void importData(Job job) {

        // Added Values
        entity.put("jobType", job.getJobType());
        entity.put("JobDefinition", job.getJobDefinition());
        entity.put("feeInfo", job.getFeeInfo());
        entity.put("entryDate", job.getEntryDate());
        entity.put("finishDate", job.getFinishDate());
        entity.put("requirements", job.getRequirements());
        entity.put("companyID", companyObjectID);

        // Saved Check
        entity.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                // Here you can handle errors, if thrown. Otherwise, "e" should be null
                if (e != null) {
                    Toast.makeText(view.getContext(), "Error", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(view.getContext(), "Saved", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}

