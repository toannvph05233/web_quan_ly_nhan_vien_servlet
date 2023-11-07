package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.BangLuongDAO;
import com.qlnv.dao.ChamCongDAO;
import com.qlnv.dao.NhanVienDAO;
import com.qlnv.dao.PhanCongCongTacDAO;
import com.qlnv.model.BangLuong;
import com.qlnv.model.ChamCong;
import com.qlnv.model.NhanVien;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/checkin")
public class CheckInServlet extends HttpServlet {
    ChamCongDAO chamCongDAO = new ChamCongDAO(ConnectMysql.getConnection());
    NhanVienDAO nhanVienDAO = new NhanVienDAO(ConnectMysql.getConnection());
    PhanCongCongTacDAO phanCongCongTacDAO = new PhanCongCongTacDAO(ConnectMysql.getConnection());
    BangLuongDAO bangLuongDAO = new BangLuongDAO(ConnectMysql.getConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idNV = Integer.parseInt(req.getParameter("idNV"));
        NhanVien nhanVien = nhanVienDAO.getNhanVienByID(idNV);
        if (chamCongDAO.getChamCongByEmployeeIDAndDate(nhanVien.getEmployeeID(), new Date()) != null){
            nhanVien.setCheckIn(true);
        }
        req.setAttribute("nhanVien", nhanVien);
        req.setAttribute("jobs", phanCongCongTacDAO.getPhanCongCongTacByEmployeeID(idNV));
        req.setAttribute("checkins", chamCongDAO.getAllByIdNV(idNV));
        BangLuong bangLuong = bangLuongDAO.getBangLuongByEmployeeID(idNV);
        if (bangLuong!=null){
            req.setAttribute("bangLuong",bangLuong);
        }else {
            req.setAttribute("bangLuong",new BangLuong());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/checkIn.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idNV = Integer.parseInt(req.getParameter("idNV"));
        chamCongDAO.insert(new ChamCong(idNV, new Date(),8));
        resp.sendRedirect("/nhanvien");
    }
}
