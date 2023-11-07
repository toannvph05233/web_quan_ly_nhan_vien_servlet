package com.qlnv.dao;

import com.qlnv.model.BangLuong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BangLuongDAO {
    private Connection connection;

    public BangLuongDAO(Connection connection) {
        this.connection = connection;
    }

    public void addBangLuong(BangLuong bangLuong) {
        String insertQuery = "INSERT INTO BangLuong (EmployeeID, ContractType, SalaryGrade, SalaryCoefficient, Allowances, Insurance, Salary) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, bangLuong.getEmployeeID());
            preparedStatement.setString(2, bangLuong.getContractType());
            preparedStatement.setInt(3, bangLuong.getSalaryGrade());
            preparedStatement.setDouble(4, bangLuong.getSalaryCoefficient());
            preparedStatement.setDouble(5, bangLuong.getAllowances());
            preparedStatement.setDouble(6, bangLuong.getInsurance());
            preparedStatement.setDouble(7, bangLuong.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBangLuong(BangLuong bangLuong) {
        String updateQuery = "UPDATE BangLuong SET ContractType = ?, SalaryGrade = ?, SalaryCoefficient = ?, Allowances = ?, Insurance = ?, Salary = ? WHERE EmployeeID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, bangLuong.getContractType());
            preparedStatement.setInt(2, bangLuong.getSalaryGrade());
            preparedStatement.setDouble(3, bangLuong.getSalaryCoefficient());
            preparedStatement.setDouble(4, bangLuong.getAllowances());
            preparedStatement.setDouble(5, bangLuong.getInsurance());
            preparedStatement.setDouble(6, bangLuong.getSalary());
            preparedStatement.setInt(7, bangLuong.getEmployeeID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBangLuong(int employeeID) {
        String deleteQuery = "DELETE FROM BangLuong WHERE EmployeeID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, employeeID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BangLuong getBangLuongByEmployeeID(int employeeID) {
        String selectQuery = "SELECT * FROM BangLuong WHERE EmployeeID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, employeeID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                BangLuong bangLuong = new BangLuong();
                bangLuong.setSalaryID(resultSet.getInt("SalaryID"));
                bangLuong.setEmployeeID(resultSet.getInt("EmployeeID"));
                bangLuong.setContractType(resultSet.getString("ContractType"));
                bangLuong.setSalaryGrade(resultSet.getInt("SalaryGrade"));
                bangLuong.setSalaryCoefficient(resultSet.getDouble("SalaryCoefficient"));
                bangLuong.setAllowances(resultSet.getDouble("Allowances"));
                bangLuong.setInsurance(resultSet.getDouble("Insurance"));
                bangLuong.setSalary(resultSet.getDouble("Salary"));
                return bangLuong;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BangLuong> getAllBangLuong() {
        List<BangLuong> bangLuongs = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM BangLuong";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectAllQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BangLuong bangLuong = new BangLuong();
                bangLuong.setSalaryID(resultSet.getInt("SalaryID"));
                bangLuong.setEmployeeID(resultSet.getInt("EmployeeID"));
                bangLuong.setContractType(resultSet.getString("ContractType"));
                bangLuong.setSalaryGrade(resultSet.getInt("SalaryGrade"));
                bangLuong.setSalaryCoefficient(resultSet.getDouble("SalaryCoefficient"));
                bangLuong.setAllowances(resultSet.getDouble("Allowances"));
                bangLuong.setInsurance(resultSet.getDouble("Insurance"));
                bangLuong.setSalary(resultSet.getDouble("Salary"));
                bangLuongs.add(bangLuong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bangLuongs;
    }
}
