package com.cit360projectmark4.controller;

import com.cit360projectmark4.service.BaseService;
import com.cit360projectmark4.service.BaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println("LogoutController: doPost: starting. SID: " + request.getSession().getId());
        String page = "login.jsp";

        System.out.println("LogoutController: doPost: sending request dispatcher");
        request.getRequestDispatcher(page).include(request, response);

        session.invalidate();
        System.out.println("LogoutController: doPost: " + username + " has logged out");
    }
}
