package com.back4app.quickstartexampleapp;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobList extends AppCompatActivity {
    private List<String> listSomeInfo = new ArrayList<>();
    private List<ParseObject> jobListItems = new ArrayList<>();
    private ParseQuery<ParseObject> query = ParseQuery.getQuery("Job");
    private ArrayAdapter arrayAdapter;
    private ArrayList<Job> jobListData = new ArrayList<>();
    private SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
        ListView jobList = findViewById(R.id.JobListView);

        try {
            exportOtherData();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        viewDetailed();
        jobList.setAdapter(arrayAdapter);
        jobList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position enough
                Job j = jobListData.get(position);
                String info = "Job Type: " + j.getJobType() + "\n" + "Job Definition: " + j.getJobDefinition() + "\n" + "Price: " + Integer.toString(j.getFeeInfo())
                        + "\n" + "Entry Date: " + ft.format(j.getEntryDate()) + "\n" + "Finish Date: " + ft.format(j.getFinishDate());

                AlertDialog.Builder builder = new AlertDialog.Builder(JobList.this);
                builder.setMessage(info);
                builder.setTitle("Job Information");
                builder.setPositiveButton("ACCEPT", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    private void exportOtherData() throws java.text.ParseException {
        // Export Data from database
        try {
            jobListItems = query.find();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        Job j;
        for (ParseObject p : jobListItems) {
            j = new Job(p.getString("jobType"), p.getString("JobDefinition"), p.getInt("feeInfo"),
                    p.getDate("entryDate"), p.getDate("finishDate"), p.getJSONArray("requirements"), p.getObjectId());
            jobListData.add(j);
        }
    }

    private void viewDetailed()
    {
        String info;
        for (Job temp : jobListData) {
            info = "Job Type: " + temp.getJobType() + "\nPrice: " + temp.getFeeInfo() + "₺";
            listSomeInfo.add(info);
        }
        arrayAdapter = new ArrayAdapter(JobList.this, android.R.layout.simple_list_item_1, listSomeInfo);
    }


}
