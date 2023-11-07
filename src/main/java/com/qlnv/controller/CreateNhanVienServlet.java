package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.NhanVienDAO;
import com.qlnv.model.NhanVien;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/createStaff")
public class CreateNhanVienServlet extends HttpServlet {
    NhanVienDAO nhanVienDAO = new NhanVienDAO(ConnectMysql.getConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/createStaff.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = request.getParameter("FullName");
        // Lấy các giá trị kiểu Date và chuyển đổi
        Date dateOfBirth = parseDate(request.getParameter("DateOfBirth"));
        Date dateJoinYouthUnion = parseDate(request.getParameter("DateJoinYouthUnion"));
        Date dateJoinParty = parseDate(request.getParameter("DateJoinParty"));
        // Lấy các giá trị kiểu String
        String gender = request.getParameter("Gender");
        String avatar = request.getParameter("Avatar");
        String idCardNumber = request.getParameter("IDCardNumber");
        String educationalBackground = request.getParameter("EducationalBackground");
        String languageSkills = request.getParameter("LanguageSkills");
        String permanentResidence = request.getParameter("PermanentResidence");
        String address = request.getParameter("Address");
        String ethnicity = request.getParameter("Ethnicity");
        String religion = request.getParameter("Religion");
        String parents = request.getParameter("Parents");
        String siblings = request.getParameter("Siblings");
        String maritalStatus = request.getParameter("MaritalStatus");
        String children = request.getParameter("Children");
        String policyCategory = request.getParameter("PolicyCategory");
        String department = request.getParameter("Department");
        String jobTitle = request.getParameter("JobTitle");

        // Tạo đối tượng NhanVien và truyền dữ liệu đã lấy được
        NhanVien nhanVien = new NhanVien(fullName, dateOfBirth, gender, avatar, idCardNumber,
                educationalBackground, languageSkills, permanentResidence, address, ethnicity, religion,
                dateJoinYouthUnion, dateJoinParty, parents, siblings, maritalStatus, children, policyCategory,
                department, jobTitle, false);

        nhanVienDAO.addNhanVien(nhanVien);
        resp.sendRedirect("/nhanvien");
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
            return null;
        }
    }
}
