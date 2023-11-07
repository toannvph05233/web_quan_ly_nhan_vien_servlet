package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.CongTacDAO;
import com.qlnv.dao.NhanVienDAO;
import com.qlnv.dao.PhanCongCongTacDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/profile")
public class ProfileNhanVienServlet extends HttpServlet {
    NhanVienDAO nhanVienDAO = new NhanVienDAO(ConnectMysql.getConnection());
    CongTacDAO congTacDAO = new CongTacDAO(ConnectMysql.getConnection());
    PhanCongCongTacDAO phanCongCongTacDAO = new PhanCongCongTacDAO(ConnectMysql.getConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idNV = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("nhanVien", nhanVienDAO.getNhanVienByID(idNV));
        req.setAttribute("workHistory", congTacDAO.getCongTacByEmployeeID(idNV));
        req.setAttribute("jobs", phanCongCongTacDAO.getPhanCongCongTacByEmployeeID(idNV));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");


        dispatcher.forward(req,resp);
    }
}
