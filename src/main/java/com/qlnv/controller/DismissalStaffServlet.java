package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.NhanVienDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/dismissal")
public class DismissalStaffServlet extends HttpServlet {
    NhanVienDAO nhanVienDAO = new NhanVienDAO(ConnectMysql.getConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idNV = Integer.parseInt(req.getParameter("id"));
        nhanVienDAO.dismissalNhanVien(idNV);
        resp.sendRedirect("/nhanvien");
    }
}
