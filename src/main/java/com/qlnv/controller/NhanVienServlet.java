package com.qlnv.controller;

import com.qlnv.connectSQL.ConnectMysql;
import com.qlnv.dao.ChamCongDAO;
import com.qlnv.dao.NhanVienDAO;
import com.qlnv.model.NhanVien;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/nhanvien")
public class NhanVienServlet extends HttpServlet {

    NhanVienDAO nhanVienDAO = new NhanVienDAO(ConnectMysql.getConnection());
    ChamCongDAO chamCongDAO = new ChamCongDAO(ConnectMysql.getConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhanVien> nhanVienCheckIns = new ArrayList<>();
        List<NhanVien> nhanVienNoCheckIns = new ArrayList<>();
        List<NhanVien> nhanViens = new ArrayList<>();

        String contract = req.getParameter("contract");
        if (contract == null) {
            nhanViens = nhanVienDAO.getAllNhanVien();
        } else if (contract.equals("true")) {
            nhanViens = nhanVienDAO.getAllNhanVienByType(true);
        } else {
            nhanViens = nhanVienDAO.getAllNhanVienByType(false);
        }
        filterStaff(nhanVienCheckIns,nhanVienNoCheckIns,nhanViens);

        req.setAttribute("nhanVienCheckIns", nhanVienCheckIns);
        req.setAttribute("nhanVienNoCheckIns", nhanVienNoCheckIns);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhanVien> nhanVienCheckIns = new ArrayList<>();
        List<NhanVien> nhanVienNoCheckIns = new ArrayList<>();
        List<NhanVien> nhanViens = new ArrayList<>();
        String search = req.getParameter("search");
        nhanViens = nhanVienDAO.searchNhanVien(search);
        filterStaff(nhanVienCheckIns,nhanVienNoCheckIns,nhanViens);

        req.setAttribute("nhanVienCheckIns", nhanVienCheckIns);
        req.setAttribute("nhanVienNoCheckIns", nhanVienNoCheckIns);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);

    }


    public void filterStaff(List<NhanVien> nhanVienCheckIns,List<NhanVien> nhanVienNoCheckIns, List<NhanVien> nhanViens){
        for (NhanVien nv : nhanViens) {
            if (chamCongDAO.getChamCongByEmployeeIDAndDate(nv.getEmployeeID(), new Date()) != null) {
                nv.setCheckIn(true);
                nhanVienCheckIns.add(nv);
            } else {
                nhanVienNoCheckIns.add(nv);
            }
        }
    }
}
