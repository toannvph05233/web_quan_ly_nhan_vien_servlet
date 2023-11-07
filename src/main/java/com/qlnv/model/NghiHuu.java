package com.qlnv.model;

import java.util.Date;

public class NghiHuu {
    private int RetirementID;
    private int EmployeeID;
    private Date RetirementDate;

    public NghiHuu() {
    }

    public NghiHuu(int retirementID, int employeeID, Date retirementDate) {
        RetirementID = retirementID;
        EmployeeID = employeeID;
        RetirementDate = retirementDate;
    }

    public int getRetirementID() {
        return RetirementID;
    }

    public void setRetirementID(int retirementID) {
        RetirementID = retirementID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public Date getRetirementDate() {
        return RetirementDate;
    }

    public void setRetirementDate(Date retirementDate) {
        RetirementDate = retirementDate;
    }
}

