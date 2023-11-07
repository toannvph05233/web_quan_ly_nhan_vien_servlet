package com.qlnv.dao;

import com.qlnv.model.ChamCong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChamCongDAO {
    private Connection connection;

    public ChamCongDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(ChamCong chamCong) {
        String query = "INSERT INTO ChamCong (EmployeeID, AttendanceDate, HoursWorked) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, chamCong.getEmployeeID());
            preparedStatement.setDate(2, new java.sql.Date(chamCong.getAttendanceDate().getTime()));
            preparedStatement.setDouble(3, chamCong.getHoursWorked());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(ChamCong chamCong) throws SQLException {
        String query = "UPDATE ChamCong SET EmployeeID = ?, AttendanceDate = ?, HoursWorked = ? WHERE AttendanceID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, chamCong.getEmployeeID());
            preparedStatement.setDate(2, new java.sql.Date(chamCong.getAttendanceDate().getTime()));
            preparedStatement.setDouble(3, chamCong.getHoursWorked());
            preparedStatement.setInt(4, chamCong.getAttendanceID());
            preparedStatement.executeUpdate();
        }
    }

    public void delete(int attendanceID) throws SQLException {
        String query = "DELETE FROM ChamCong WHERE AttendanceID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, attendanceID);
            preparedStatement.executeUpdate();
        }
    }

    public ChamCong get(int attendanceID) throws SQLException {
        String query = "SELECT * FROM ChamCong WHERE AttendanceID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, attendanceID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToChamCong(resultSet);
                }
            }
        }
        return null;
    }

    public List<ChamCong> getAllByIdNV(int idNV){
        List<ChamCong> chamCongList = new ArrayList<>();
        String query = "SELECT * FROM ChamCong WHERE YEAR(AttendanceDate) = YEAR(CURRENT_DATE) AND MONTH(AttendanceDate) = MONTH(CURRENT_DATE) AND EmployeeID = " + idNV;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ChamCong chamCong = mapResultSetToChamCong(resultSet);
                chamCongList.add(chamCong);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return chamCongList;
    }

    private ChamCong mapResultSetToChamCong(ResultSet resultSet) throws SQLException {
        ChamCong chamCong = new ChamCong();
        chamCong.setAttendanceID(resultSet.getInt("AttendanceID"));
        chamCong.setEmployeeID(resultSet.getInt("EmployeeID"));
        chamCong.setAttendanceDate(resultSet.getDate("AttendanceDate"));
        chamCong.setHoursWorked(resultSet.getDouble("HoursWorked"));
        return chamCong;
    }

    public ChamCong getChamCongByEmployeeIDAndDate(int employeeID, Date attendanceDate) {
        String query = "SELECT * FROM ChamCong WHERE EmployeeID = ? AND AttendanceDate = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, employeeID);
            preparedStatement.setDate(2, new java.sql.Date(attendanceDate.getTime()));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToChamCong(resultSet);
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
