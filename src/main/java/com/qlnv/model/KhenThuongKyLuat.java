package com.qlnv.model;

import java.util.Date;

public class KhenThuongKyLuat {
    private int RewardPenaltyID;
    private int EmployeeID;
    private String Type;
    private Date Date;
    private String Content;

    public KhenThuongKyLuat() {
    }

    public KhenThuongKyLuat(int rewardPenaltyID, int employeeID, String type, java.util.Date date, String content) {
        RewardPenaltyID = rewardPenaltyID;
        EmployeeID = employeeID;
        Type = type;
        Date = date;
        Content = content;
    }

    public int getRewardPenaltyID() {
        return RewardPenaltyID;
    }

    public void setRewardPenaltyID(int rewardPenaltyID) {
        RewardPenaltyID = rewardPenaltyID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
