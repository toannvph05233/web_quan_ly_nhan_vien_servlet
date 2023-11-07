package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.BangLuongDAO;
import com.qlnv.model.BangLuong;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bangCong")
public class BangCongServlet extends HttpServlet {
    BangLuongDAO bangLuongDAO = new BangLuongDAO(ConnectMysql.getConnection());
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        int employeeID = Integer.parseInt(request.getParameter("EmployeeID"));
        String salaryID = request.getParameter("SalaryID");
        String contractType = request.getParameter("ContractType");
        int salaryGrade = Integer.parseInt(request.getParameter("SalaryGrade"));
        double salaryCoefficient = Double.parseDouble(request.getParameter("SalaryCoefficient"));
        double allowances = Double.parseDouble(request.getParameter("Allowances"));
        double insurance = Double.parseDouble(request.getParameter("Insurance"));
        double salary = Double.parseDouble(request.getParameter("Salary"));
        if (salaryID == null){
            BangLuong bangLuong = new BangLuong(employeeID,contractType,salaryGrade,salaryCoefficient,allowances,insurance,salary);
            bangLuongDAO.addBangLuong(bangLuong);
        }else {
            BangLuong bangLuong = new BangLuong(Integer.parseInt(salaryID),employeeID,contractType,salaryGrade,salaryCoefficient,allowances,insurance,salary);
            bangLuongDAO.updateBangLuong(bangLuong);
        }
        resp.sendRedirect("/nhanvien");

    }


}
