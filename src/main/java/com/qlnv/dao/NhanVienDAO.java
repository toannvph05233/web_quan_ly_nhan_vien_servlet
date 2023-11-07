package com.qlnv.dao;

import com.qlnv.model.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhanVienDAO {
    private Connection connection;

    public NhanVienDAO(Connection connection) {
        this.connection = connection;
    }

    public void addNhanVien(NhanVien nhanVien) {
        String insertQuery = "INSERT INTO NhanVien (FullName, DateOfBirth, Gender, IDCardNumber, EducationalBackground, LanguageSkills, PermanentResidence, Address, Ethnicity, Religion, DateJoinYouthUnion, DateJoinParty, Parents, Siblings, MaritalStatus, Children, PolicyCategory, Department, JobTitle, Avatar) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, nhanVien.getFullName());
            preparedStatement.setDate(2, new java.sql.Date(nhanVien.getDateOfBirth().getTime()));
            preparedStatement.setString(3, nhanVien.getGender());
            preparedStatement.setString(4, nhanVien.getIDCardNumber());
            preparedStatement.setString(5, nhanVien.getEducationalBackground());
            preparedStatement.setString(6, nhanVien.getLanguageSkills());
            preparedStatement.setString(7, nhanVien.getPermanentResidence());
            preparedStatement.setString(8, nhanVien.getAddress());
            preparedStatement.setString(9, nhanVien.getEthnicity());
            preparedStatement.setString(10, nhanVien.getReligion());
            preparedStatement.setDate(11, new java.sql.Date(nhanVien.getDateJoinYouthUnion().getTime()));
            preparedStatement.setDate(12, new java.sql.Date(nhanVien.getDateJoinParty().getTime()));
            preparedStatement.setString(13, nhanVien.getParents());
            preparedStatement.setString(14, nhanVien.getSiblings());
            preparedStatement.setString(15, nhanVien.getMaritalStatus());
            preparedStatement.setString(16, nhanVien.getChildren());
            preparedStatement.setString(17, nhanVien.getPolicyCategory());
            preparedStatement.setString(18, nhanVien.getDepartment());
            preparedStatement.setString(19, nhanVien.getJobTitle());
            preparedStatement.setString(20, nhanVien.getAvatar());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNhanVien(NhanVien nhanVien) {
        String updateQuery = "UPDATE NhanVien SET FullName = ?, DateOfBirth = ?, Gender = ?, IDCardNumber = ?, EducationalBackground = ?, LanguageSkills = ?, PermanentResidence = ?, Address = ?, Ethnicity = ?, Religion = ?, DateJoinYouthUnion = ?, DateJoinParty = ?, Parents = ?, Siblings = ?, MaritalStatus = ?, Children = ?, PolicyCategory = ?, Department = ?, JobTitle = ?, Avatar = ? WHERE EmployeeID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, nhanVien.getFullName());
            preparedStatement.setDate(2, new java.sql.Date(nhanVien.getDateOfBirth().getTime()));
            preparedStatement.setString(3, nhanVien.getGender());
            preparedStatement.setString(4, nhanVien.getIDCardNumber());
            preparedStatement.setString(5, nhanVien.getEducationalBackground());
            preparedStatement.setString(6, nhanVien.getLanguageSkills());
            preparedStatement.setString(7, nhanVien.getPermanentResidence());
            preparedStatement.setString(8, nhanVien.getAddress());
            preparedStatement.setString(9, nhanVien.getEthnicity());
            preparedStatement.setString(10, nhanVien.getReligion());
            preparedStatement.setDate(11, new java.sql.Date(nhanVien.getDateJoinYouthUnion().getTime()));
            preparedStatement.setDate(12, new java.sql.Date(nhanVien.getDateJoinParty().getTime()));
            preparedStatement.setString(13, nhanVien.getParents());
            preparedStatement.setString(14, nhanVien.getSiblings());
            preparedStatement.setString(15, nhanVien.getMaritalStatus());
            preparedStatement.setString(16, nhanVien.getChildren());
            preparedStatement.setString(17, nhanVien.getPolicyCategory());
            preparedStatement.setString(18, nhanVien.getDepartment());
            preparedStatement.setString(19, nhanVien.getJobTitle());
            preparedStatement.setString(20, nhanVien.getAvatar());
            preparedStatement.setInt(21, nhanVien.getEmployeeID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dismissalNhanVien(int idNV) {
        String updateQuery = "UPDATE NhanVien SET StatusStaff = 0 WHERE EmployeeID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, idNV);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNhanVien(int employeeID) {
        String deleteQuery = "DELETE FROM NhanVien WHERE EmployeeID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, employeeID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<NhanVien> searchNhanVien(String keyword) {
        List<NhanVien> nhanViens = new ArrayList<>();
        String searchQuery = "SELECT * FROM NhanVien WHERE FullName LIKE ? OR JobTitle LIKE ? OR PermanentResidence LIKE ? OR EducationalBackground LIKE ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(searchQuery);
            preparedStatement.setString(1, "%" + keyword + "%");
            preparedStatement.setString(2, "%" + keyword + "%");
            preparedStatement.setString(3, "%" + keyword + "%");
            preparedStatement.setString(4, "%" + keyword + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setEmployeeID(resultSet.getInt("EmployeeID"));
                nhanVien.setFullName(resultSet.getString("FullName"));
                nhanVien.setDateOfBirth(resultSet.getDate("DateOfBirth"));
                nhanVien.setGender(resultSet.getString("Gender"));
                nhanVien.setIDCardNumber(resultSet.getString("IDCardNumber"));
                nhanVien.setEducationalBackground(resultSet.getString("EducationalBackground"));
                nhanVien.setLanguageSkills(resultSet.getString("LanguageSkills"));
                nhanVien.setPermanentResidence(resultSet.getString("PermanentResidence"));
                nhanVien.setAddress(resultSet.getString("Address"));
                nhanVien.setEthnicity(resultSet.getString("Ethnicity"));
                nhanVien.setReligion(resultSet.getString("Religion"));
                nhanVien.setDateJoinYouthUnion(resultSet.getDate("DateJoinYouthUnion"));
                nhanVien.setDateJoinParty(resultSet.getDate("DateJoinParty"));
                nhanVien.setParents(resultSet.getString("Parents"));
                nhanVien.setSiblings(resultSet.getString("Siblings"));
                nhanVien.setMaritalStatus(resultSet.getString("MaritalStatus"));
                nhanVien.setChildren(resultSet.getString("Children"));
                nhanVien.setPolicyCategory(resultSet.getString("PolicyCategory"));
                nhanVien.setDepartment(resultSet.getString("Department"));
                nhanVien.setJobTitle(resultSet.getString("JobTitle"));
                nhanVien.setAvatar(resultSet.getString("Avatar"));
                nhanViens.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nhanViens;
    }

    public NhanVien getNhanVienByID(int employeeID) {
        String selectQuery = "SELECT * FROM NhanVien WHERE EmployeeID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, employeeID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setEmployeeID(resultSet.getInt("EmployeeID"));
                nhanVien.setFullName(resultSet.getString("FullName"));
                nhanVien.setDateOfBirth(resultSet.getDate("DateOfBirth"));
                nhanVien.setGender(resultSet.getString("Gender"));
                nhanVien.setIDCardNumber(resultSet.getString("IDCardNumber"));
                nhanVien.setEducationalBackground(resultSet.getString("EducationalBackground"));
                nhanVien.setLanguageSkills(resultSet.getString("LanguageSkills"));
                nhanVien.setPermanentResidence(resultSet.getString("PermanentResidence"));
                nhanVien.setAddress(resultSet.getString("Address"));
                nhanVien.setEthnicity(resultSet.getString("Ethnicity"));
                nhanVien.setReligion(resultSet.getString("Religion"));
                nhanVien.setDateJoinYouthUnion(resultSet.getDate("DateJoinYouthUnion"));
                nhanVien.setDateJoinParty(resultSet.getDate("DateJoinParty"));
                nhanVien.setParents(resultSet.getString("Parents"));
                nhanVien.setSiblings(resultSet.getString("Siblings"));
                nhanVien.setMaritalStatus(resultSet.getString("MaritalStatus"));
                nhanVien.setChildren(resultSet.getString("Children"));
                nhanVien.setPolicyCategory(resultSet.getString("PolicyCategory"));
                nhanVien.setDepartment(resultSet.getString("Department"));
                nhanVien.setJobTitle(resultSet.getString("JobTitle"));
                nhanVien.setAvatar(resultSet.getString("Avatar"));

                return nhanVien;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> nhanViens = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM NhanVien where StatusStaff=1";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectAllQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setEmployeeID(resultSet.getInt("EmployeeID"));
                nhanVien.setFullName(resultSet.getString("FullName"));
                nhanVien.setDateOfBirth(resultSet.getDate("DateOfBirth"));
                nhanVien.setGender(resultSet.getString("Gender"));
                nhanVien.setIDCardNumber(resultSet.getString("IDCardNumber"));
                nhanVien.setEducationalBackground(resultSet.getString("EducationalBackground"));
                nhanVien.setLanguageSkills(resultSet.getString("LanguageSkills"));
                nhanVien.setPermanentResidence(resultSet.getString("PermanentResidence"));
                nhanVien.setAddress(resultSet.getString("Address"));
                nhanVien.setEthnicity(resultSet.getString("Ethnicity"));
                nhanVien.setReligion(resultSet.getString("Religion"));
                nhanVien.setDateJoinYouthUnion(resultSet.getDate("DateJoinYouthUnion"));
                nhanVien.setDateJoinParty(resultSet.getDate("DateJoinParty"));
                nhanVien.setParents(resultSet.getString("Parents"));
                nhanVien.setSiblings(resultSet.getString("Siblings"));
                nhanVien.setMaritalStatus(resultSet.getString("MaritalStatus"));
                nhanVien.setChildren(resultSet.getString("Children"));
                nhanVien.setPolicyCategory(resultSet.getString("PolicyCategory"));
                nhanVien.setDepartment(resultSet.getString("Department"));
                nhanVien.setJobTitle(resultSet.getString("JobTitle"));
                nhanVien.setAvatar(resultSet.getString("Avatar"));
                nhanViens.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanViens;
    }

    public List<NhanVien> getAllNhanVienByType(boolean isContract) {
        List<NhanVien> nhanViens = new ArrayList<>();
        String selectAllQuery = "";
        if (isContract) {
            selectAllQuery = "SELECT NhanVien.* FROM qlnv.NhanVien join BangLuong on NhanVien.EmployeeID = BangLuong.EmployeeID\n" +
                    "where ContractType = 'Hợp đồng'";
        } else {
            selectAllQuery = "SELECT NhanVien.* FROM qlnv.NhanVien join BangLuong on NhanVien.EmployeeID = BangLuong.EmployeeID\n" +
                    "where ContractType = 'Biên chế'";
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectAllQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setEmployeeID(resultSet.getInt("EmployeeID"));
                nhanVien.setFullName(resultSet.getString("FullName"));
                nhanVien.setDateOfBirth(resultSet.getDate("DateOfBirth"));
                nhanVien.setGender(resultSet.getString("Gender"));
                nhanVien.setIDCardNumber(resultSet.getString("IDCardNumber"));
                nhanVien.setEducationalBackground(resultSet.getString("EducationalBackground"));
                nhanVien.setLanguageSkills(resultSet.getString("LanguageSkills"));
                nhanVien.setPermanentResidence(resultSet.getString("PermanentResidence"));
                nhanVien.setAddress(resultSet.getString("Address"));
                nhanVien.setEthnicity(resultSet.getString("Ethnicity"));
                nhanVien.setReligion(resultSet.getString("Religion"));
                nhanVien.setDateJoinYouthUnion(resultSet.getDate("DateJoinYouthUnion"));
                nhanVien.setDateJoinParty(resultSet.getDate("DateJoinParty"));
                nhanVien.setParents(resultSet.getString("Parents"));
                nhanVien.setSiblings(resultSet.getString("Siblings"));
                nhanVien.setMaritalStatus(resultSet.getString("MaritalStatus"));
                nhanVien.setChildren(resultSet.getString("Children"));
                nhanVien.setPolicyCategory(resultSet.getString("PolicyCategory"));
                nhanVien.setDepartment(resultSet.getString("Department"));
                nhanVien.setJobTitle(resultSet.getString("JobTitle"));
                nhanVien.setAvatar(resultSet.getString("Avatar"));
                nhanViens.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanViens;
    }
}

