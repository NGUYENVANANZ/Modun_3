package com.example.quanlinhanvien.controller;

import com.example.quanlinhanvien.models.NhanVien;
import com.example.quanlinhanvien.models.User;
import com.example.quanlinhanvien.service.NhanVienService;
import com.example.quanlinhanvien.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = "/NhanVienServlet")
public class NhanVienServlet extends HttpServlet {
    private final NhanVienService nhanVienService = new NhanVienService();
    private final UserService userService = new UserService();

    List<NhanVien> nhanViens = nhanVienService.showAll();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "Creat":
                creatNhanvien(request, response);
                break;
            case "Edit":
                editNhanVien(request, response);
                break;
            case "delete":
                deleteNhanVien(request, response);
                break;
            case "showEditNhanVien":
                showEditNhanVien(request, response);
                break;
            default:
                showAllNhanVien(request, response);

        }
    }

    private void showEditNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien nhanVien = nhanVienService.findById(id);
        request.setAttribute("newNhanvien", nhanVien);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void creatNhanvien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String img = request.getParameter("img");
        nhanVienService.create(new NhanVien(id, name, age, img));

        showAllNhanVien(request, response);

    }


    private void editNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String img = request.getParameter("img");
        nhanVienService.editById(id, new NhanVien(id, name, age, img));

        showAllNhanVien(request, response);
    }

    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        nhanVienService.deleteById(id);

        showAllNhanVien(request, response);

    }

    private void showAllNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("nhanViens", nhanViens);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/List.jsp");
        requestDispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");


        if (userService.checkUser(username, password)) {
            showAllNhanVien(request, response);
        }else {
            response.sendRedirect("/index.jsp");
        }
    }
}
