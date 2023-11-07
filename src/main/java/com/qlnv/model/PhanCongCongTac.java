package com.qlnv.model;

import java.util.Date;

public class PhanCongCongTac {
    private int WorkAssignmentID;
    private int EmployeeID;
    private Date AssignmentDate;
    private String JobDescription;

    public PhanCongCongTac(int workAssignmentID, int employeeID, Date assignmentDate, String jobDescription) {
        WorkAssignmentID = workAssignmentID;
        EmployeeID = employeeID;
        AssignmentDate = assignmentDate;
        JobDescription = jobDescription;
    }

    public PhanCongCongTac() {
    }

    public int getWorkAssignmentID() {
        return WorkAssignmentID;
    }

    public void setWorkAssignmentID(int workAssignmentID) {
        WorkAssignmentID = workAssignmentID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public Date getAssignmentDate() {
        return AssignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        AssignmentDate = assignmentDate;
    }

    public String getJobDescription() {
        return JobDescription;
    }

    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }
}

