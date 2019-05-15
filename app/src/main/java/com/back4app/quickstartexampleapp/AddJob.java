package com.back4app.quickstartexampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class AddJob extends AppCompatActivity {


    private SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm");
    private JSONArray requirements = new JSONArray();
    private ParseObject entity = new ParseObject("Job");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);

        final TextView jobType = findViewById(R.id.JobType);
        final TextView jobDefinition = findViewById(R.id.JobDefinition);
        final TextView price = findViewById(R.id.Price);
        final TextView entryDate = findViewById(R.id.EntryDate);
        final TextView entryTime = findViewById(R.id.EntryTime);
        final TextView finishDate = findViewById(R.id.FinishDate);
        final TextView finishTime = findViewById(R.id.FinishTime);
        final TextView req= findViewById(R.id.Requirements);
        Button addJobButton = findViewById(R.id.addJobButton);

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

    }

    private void importData(Job job) {

        // Added Values
        entity.put("jobType", job.getJobType());
        entity.put("JobDefinition", job.getJobDefinition());
        entity.put("feeInfo", job.getFeeInfo());
        entity.put("entryDate", job.getEntryDate());
        entity.put("finishDate", job.getFinishDate());
        entity.put("requirements", job.getRequirements());

        // Saved Check
        entity.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                // Here you can handle errors, if thrown. Otherwise, "e" should be null
                if(e != null) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
