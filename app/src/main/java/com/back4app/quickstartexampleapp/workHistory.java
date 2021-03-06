package com.back4app.quickstartexampleapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
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

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class workHistory extends Fragment {
    private View view;
    private List<String> listSomeInfo = new ArrayList<>();
    private List<ParseObject> jobListItems = new ArrayList<>();
    private ParseQuery<ParseObject> query = ParseQuery.getQuery("Job");
    private ArrayAdapter arrayAdapter;
    private ArrayList<Job> jobListData = new ArrayList<>();
    private SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm");
    private String employeeObjectID = "";
    SharedPreferences prf;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_work_history, null);
        ListView jobList = view.findViewById(R.id.EmployeeList);
        prf = getActivity().getApplicationContext().getSharedPreferences("sessionID", Context.MODE_PRIVATE);
        employeeObjectID = prf.getString("objectID", null);
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

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage(info);
                builder.setTitle("Job Information");
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

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
            query.whereEqualTo("EmployeeUsername", employeeObjectID);
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
        arrayAdapter = new ArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1, listSomeInfo);
    }
}
