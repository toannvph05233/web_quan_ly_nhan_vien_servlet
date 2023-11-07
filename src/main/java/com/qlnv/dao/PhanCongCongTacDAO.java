package com.qlnv.dao;

import com.qlnv.model.PhanCongCongTac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhanCongCongTacDAO {
    private Connection connection;

    public PhanCongCongTacDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPhanCongCongTac(PhanCongCongTac phanCongCongTac) {
        String insertQuery = "INSERT INTO PhanCongCongTac (EmployeeID, AssignmentDate, JobDescription) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, phanCongCongTac.getEmployeeID());
            preparedStatement.setDate(2, new java.sql.Date(phanCongCongTac.getAssignmentDate().getTime()));
            preparedStatement.setString(3, phanCongCongTac.getJobDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePhanCongCongTac(PhanCongCongTac phanCongCongTac) {
        String updateQuery = "UPDATE PhanCongCongTac SET EmployeeID = ?, AssignmentDate = ?, JobDescription = ? WHERE WorkAssignmentID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, phanCongCongTac.getEmployeeID());
            preparedStatement.setDate(2, new java.sql.Date(phanCongCongTac.getAssignmentDate().getTime()));
            preparedStatement.setString(3, phanCongCongTac.getJobDescription());
            preparedStatement.setInt(4, phanCongCongTac.getWorkAssignmentID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePhanCongCongTac(int workAssignmentID) {
        String deleteQuery = "DELETE FROM PhanCongCongTac WHERE WorkAssignmentID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, workAssignmentID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PhanCongCongTac> getPhanCongCongTacByEmployeeID(int employeeID) {
        List<PhanCongCongTac> phanCongCongTacs = new ArrayList<>();
        String selectQuery = "SELECT * FROM PhanCongCongTac WHERE EmployeeID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, employeeID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PhanCongCongTac phanCongCongTac = new PhanCongCongTac();
                phanCongCongTac.setWorkAssignmentID(resultSet.getInt("WorkAssignmentID"));
                phanCongCongTac.setEmployeeID(resultSet.getInt("EmployeeID"));
                phanCongCongTac.setAssignmentDate(resultSet.getDate("AssignmentDate"));
                phanCongCongTac.setJobDescription(resultSet.getString("JobDescription"));
                phanCongCongTacs.add(phanCongCongTac);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phanCongCongTacs;
    }
}

