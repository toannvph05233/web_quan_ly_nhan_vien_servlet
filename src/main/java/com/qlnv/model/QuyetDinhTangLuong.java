package com.qlnv.model;

import java.util.Date;

public class QuyetDinhTangLuong {
    private int SalaryIncreaseDecisionID;
    private int EmployeeID;
    private Date DecisionDate;
    private double SalaryIncreaseAmount;

    public QuyetDinhTangLuong() {
    }

    public QuyetDinhTangLuong(int salaryIncreaseDecisionID, int employeeID, Date decisionDate, double salaryIncreaseAmount) {
        SalaryIncreaseDecisionID = salaryIncreaseDecisionID;
        EmployeeID = employeeID;
        DecisionDate = decisionDate;
        SalaryIncreaseAmount = salaryIncreaseAmount;
    }

    public int getSalaryIncreaseDecisionID() {
        return SalaryIncreaseDecisionID;
    }

    public void setSalaryIncreaseDecisionID(int salaryIncreaseDecisionID) {
        SalaryIncreaseDecisionID = salaryIncreaseDecisionID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public Date getDecisionDate() {
        return DecisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        DecisionDate = decisionDate;
    }

    public double getSalaryIncreaseAmount() {
        return SalaryIncreaseAmount;
    }

    public void setSalaryIncreaseAmount(double salaryIncreaseAmount) {
        SalaryIncreaseAmount = salaryIncreaseAmount;
    }
}

