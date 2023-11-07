package com.qlnv.model;

import java.util.Date;

public class CongTac {
    private int WorkHistoryID;
    private int EmployeeID;
    private Date StartDate;
    private Date EndDate;
    private String JobDescription;

    public CongTac() {
    }

    public CongTac(int workHistoryID, int employeeID, Date startDate, Date endDate, String jobDescription) {
        WorkHistoryID = workHistoryID;
        EmployeeID = employeeID;
        StartDate = startDate;
        EndDate = endDate;
        JobDescription = jobDescription;
    }

    public int getWorkHistoryID() {
        return WorkHistoryID;
    }

    public void setWorkHistoryID(int workHistoryID) {
        WorkHistoryID = workHistoryID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getJobDescription() {
        return JobDescription;
    }

    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }
}

