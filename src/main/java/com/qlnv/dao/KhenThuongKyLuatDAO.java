package com.qlnv.dao;

import com.qlnv.model.KhenThuongKyLuat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhenThuongKyLuatDAO {
    private Connection connection;

    public KhenThuongKyLuatDAO(Connection connection) {
        this.connection = connection;
    }

    public void addKhenThuongKyLuat(KhenThuongKyLuat khenThuongKyLuat) {
        String insertQuery = "INSERT INTO KhenThuongKyLuat (EmployeeID, Type, Date, Content) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, khenThuongKyLuat.getEmployeeID());
            preparedStatement.setString(2, khenThuongKyLuat.getType());
            preparedStatement.setDate(3, new java.sql.Date(khenThuongKyLuat.getDate().getTime()));
            preparedStatement.setString(4, khenThuongKyLuat.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateKhenThuongKyLuat(KhenThuongKyLuat khenThuongKyLuat) {
        String updateQuery = "UPDATE KhenThuongKyLuat SET EmployeeID = ?, Type = ?, Date = ?, Content = ? WHERE RewardPenaltyID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, khenThuongKyLuat.getEmployeeID());
            preparedStatement.setString(2, khenThuongKyLuat.getType());
            preparedStatement.setDate(3, new java.sql.Date(khenThuongKyLuat.getDate().getTime()));
            preparedStatement.setString(4, khenThuongKyLuat.getContent());
            preparedStatement.setInt(5, khenThuongKyLuat.getRewardPenaltyID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteKhenThuongKyLuat(int rewardPenaltyID) {
        String deleteQuery = "DELETE FROM KhenThuongKyLuat WHERE RewardPenaltyID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, rewardPenaltyID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<KhenThuongKyLuat> getKhenThuongKyLuatByEmployeeID(int employeeID) {
        List<KhenThuongKyLuat> khenThuongKyLuats = new ArrayList<>();
        String selectQuery = "SELECT * FROM KhenThuongKyLuat WHERE EmployeeID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, employeeID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                KhenThuongKyLuat khenThuongKyLuat = new KhenThuongKyLuat();
                khenThuongKyLuat.setRewardPenaltyID(resultSet.getInt("RewardPenaltyID"));
                khenThuongKyLuat.setEmployeeID(resultSet.getInt("EmployeeID"));
                khenThuongKyLuat.setType(resultSet.getString("Type"));
                khenThuongKyLuat.setDate(resultSet.getDate("Date"));
                khenThuongKyLuat.setContent(resultSet.getString("Content"));
                khenThuongKyLuats.add(khenThuongKyLuat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khenThuongKyLuats;
    }
}

