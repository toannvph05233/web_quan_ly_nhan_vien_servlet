package com.qlnv.model;

import java.util.Date;

public class ChamCong {
    private int AttendanceID;
    private int EmployeeID;
    private Date AttendanceDate;
    private double HoursWorked;

    public ChamCong() {
    }

    public ChamCong(int employeeID, Date attendanceDate, double hoursWorked) {
        EmployeeID = employeeID;
        AttendanceDate = attendanceDate;
        HoursWorked = hoursWorked;
    }

    public int getAttendanceID() {
        return AttendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        AttendanceID = attendanceID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public Date getAttendanceDate() {
        return AttendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        AttendanceDate = attendanceDate;
    }

    public double getHoursWorked() {
        return HoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        HoursWorked = hoursWorked;
    }

    // Constructors, getters, and setters
}

