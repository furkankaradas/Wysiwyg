package com.back4app.quickstartexampleapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class jobListFragment extends Fragment {
    private View view;
    private List<String> listSomeInfo = new ArrayList<>();
    private List<ParseObject> jobListItems = new ArrayList<>();
    private ParseQuery<ParseObject> query = ParseQuery.getQuery("Job");
    private ArrayAdapter arrayAdapter;
    private ArrayList<Job> jobListData = new ArrayList<>();
    private SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm");
    private String employeeObjectID = "";
    SharedPreferences prf;
    private Job acceptJob;
    private Date workDate;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_job_list, null);

        prf = getActivity().getApplicationContext().getSharedPreferences("sessionID", Context.MODE_PRIVATE);
        employeeObjectID = prf.getString("objectID", null);

        ListView jobList = view.findViewById(R.id.JobListView);
        try {
            basakfunction();
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
                acceptJob = jobListData.get(position);
                String info = "Job Type: " + acceptJob.getJobType() + "\n" + "Job Definition: " + acceptJob.getJobDefinition() + "\n" + "Price: " + Integer.toString(acceptJob.getFeeInfo())
                        + "\n" + "Entry Date: " + ft.format(acceptJob.getEntryDate()) + "\n" + "Finish Date: " + ft.format(acceptJob.getFinishDate());

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage(info);
                builder.setTitle("Job Information");
                builder.setPositiveButton("ACCEPT", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        exchangeJob(acceptJob);
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

        return view;
    }

    private void exportOtherData() throws java.text.ParseException {
        // Export Data from database
        try {
            query.whereLessThanOrEqualTo("entryDate", workDate);
            query.whereGreaterThanOrEqualTo("finishDate", workDate);
            jobListItems = query.find();

        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        Job j;
        for (ParseObject p : jobListItems) {
            if(p.getString("EmployeeUsername") == null)
            {
                j = new Job(p.getString("jobType"), p.getString("JobDefinition"), p.getInt("feeInfo"),
                        p.getDate("entryDate"), p.getDate("finishDate"), p.getJSONArray("requirements"), p.getObjectId());
                jobListData.add(j);
            }
        }
    }

    private void viewDetailed()
    {
        String info;
        for (Job temp : jobListData) {
            info = "Job Type: " + temp.getJobType() + "\nPrice: " + temp.getFeeInfo() + "₺";
            listSomeInfo.add(info);
        }
        arrayAdapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, listSomeInfo);
    }

    private void exchangeJob(Job acceptJob) {
        query.getInBackground(acceptJob.getObjectID(), new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if(e == null) {
                    object.put("EmployeeUsername", employeeObjectID);
                    object.saveInBackground();
                }
            }
        });
    }

    private void basakfunction() throws ParseException {
        // employeeObjectID -> username
        ParseQuery<ParseObject> query1 = ParseQuery.getQuery("Employee");
        List<ParseObject> currentUser = new ArrayList<>();

        query1.whereEqualTo("username", employeeObjectID);
        currentUser = query1.find();
        for(ParseObject p : currentUser) {
            workDate = p.getDate("wDate");
        }
    }
}























