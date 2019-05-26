package com.back4app.quickstartexampleapp;

import org.json.JSONArray;

import java.util.Date;

public class Job {
    private String jobType;
    private String jobDefinition;
    private int feeInfo;
    private Date entryDate;
    private Date finishDate;
    private JSONArray requirements;
    private String objectID;

    public Job() {
        jobType = "";
        jobDefinition = "";
        feeInfo = 0;
        entryDate = new Date();
        finishDate = new Date();
        requirements = new JSONArray();
        objectID = "";
    }

    public Job(String jobType, String jobDefinition, int feeInfo, Date entryDate, Date finishDate, JSONArray requirements, String objectID) {
        this.jobType = jobType;
        this.jobDefinition = jobDefinition;
        this.feeInfo = feeInfo;
        this.entryDate = entryDate;
        this.finishDate = finishDate;
        this.requirements = requirements;
        this.objectID = objectID;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobDefinition() {
        return jobDefinition;
    }

    public void setJobDefinition(String jobDefinition) {
        this.jobDefinition = jobDefinition;
    }

    public int getFeeInfo() {
        return feeInfo;
    }

    public void setFeeInfo(int feeInfo) {
        this.feeInfo = feeInfo;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public JSONArray getRequirements() {
        return requirements;
    }

    public void setRequirements(JSONArray requirements) {
        this.requirements = requirements;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobType='" + jobType + '\'' +
                ", jobDefinition='" + jobDefinition + '\'' +
                ", feeInfo=" + feeInfo +
                ", entryDate=" + entryDate +
                ", finishDate=" + finishDate +
                ", requirements=" + requirements +
                '}';
    }
}
