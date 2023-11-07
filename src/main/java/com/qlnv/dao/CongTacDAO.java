package com.qlnv.dao;

import com.qlnv.model.CongTac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CongTacDAO {
    private Connection connection;

    public CongTacDAO(Connection connection) {
        this.connection = connection;
    }

    public void addCongTac(CongTac congTac) {
        String insertQuery = "INSERT INTO CongTac (EmployeeID, StartDate, EndDate, JobDescription) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, congTac.getEmployeeID());
            preparedStatement.setDate(2, new java.sql.Date(congTac.getStartDate().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(congTac.getEndDate().getTime()));
            preparedStatement.setString(4, congTac.getJobDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCongTac(CongTac congTac) {
        String updateQuery = "UPDATE CongTac SET EmployeeID = ?, StartDate = ?, EndDate = ?, JobDescription = ? WHERE WorkHistoryID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, congTac.getEmployeeID());
            preparedStatement.setDate(2, new java.sql.Date(congTac.getStartDate().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(congTac.getEndDate().getTime()));
            preparedStatement.setString(4, congTac.getJobDescription());
            preparedStatement.setInt(5, congTac.getWorkHistoryID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCongTac(int workHistoryID) {
        String deleteQuery = "DELETE FROM CongTac WHERE WorkHistoryID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, workHistoryID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CongTac> getCongTacByEmployeeID(int employeeID) {
        List<CongTac> congTacs = new ArrayList<>();
        String selectQuery = "SELECT * FROM CongTac WHERE EmployeeID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, employeeID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CongTac congTac = new CongTac();
                congTac.setWorkHistoryID(resultSet.getInt("WorkHistoryID"));
                congTac.setEmployeeID(resultSet.getInt("EmployeeID"));
                congTac.setStartDate(resultSet.getDate("StartDate"));
                congTac.setEndDate(resultSet.getDate("EndDate"));
                congTac.setJobDescription(resultSet.getString("JobDescription"));
                congTacs.add(congTac);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return congTacs;
    }
}

