package com.qlnv.model;

public class BangLuong {
    private int SalaryID;
    private int EmployeeID;
    private String ContractType;
    private int SalaryGrade;
    private double SalaryCoefficient;
    private double Allowances;
    private double Insurance;
    private double Salary;

    public BangLuong() {
    }

    public BangLuong(int salaryID, int employeeID, String contractType, int salaryGrade, double salaryCoefficient, double allowances, double insurance, double salary) {
        SalaryID = salaryID;
        EmployeeID = employeeID;
        ContractType = contractType;
        SalaryGrade = salaryGrade;
        SalaryCoefficient = salaryCoefficient;
        Allowances = allowances;
        Insurance = insurance;
        Salary = salary;
    }
    public BangLuong(int employeeID, String contractType, int salaryGrade, double salaryCoefficient, double allowances, double insurance, double salary) {
        EmployeeID = employeeID;
        ContractType = contractType;
        SalaryGrade = salaryGrade;
        SalaryCoefficient = salaryCoefficient;
        Allowances = allowances;
        Insurance = insurance;
        Salary = salary;
    }

    public int getSalaryID() {
        return SalaryID;
    }

    public void setSalaryID(int salaryID) {
        SalaryID = salaryID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getContractType() {
        return ContractType;
    }

    public void setContractType(String contractType) {
        ContractType = contractType;
    }

    public int getSalaryGrade() {
        return SalaryGrade;
    }

    public void setSalaryGrade(int salaryGrade) {
        SalaryGrade = salaryGrade;
    }

    public double getSalaryCoefficient() {
        return SalaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        SalaryCoefficient = salaryCoefficient;
    }

    public double getAllowances() {
        return Allowances;
    }

    public void setAllowances(double allowances) {
        Allowances = allowances;
    }

    public double getInsurance() {
        return Insurance;
    }

    public void setInsurance(double insurance) {
        Insurance = insurance;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }
}

