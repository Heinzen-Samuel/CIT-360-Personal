package com.cit360projectmark4.controller;

import com.cit360projectmark4.service.BaseService;
import com.cit360projectmark4.service.BaseServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("LoginController: doPost: starting. SID: " + request.getSession().getId());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("LoginController: doPost: retrieved " + username + " :: " + password);

        String page = "login.jsp";
        if(username != null && password != null) {
            System.out.println("LoginController: doPost: username and password are not null");
            BaseService loginService = new BaseServiceImpl();
            boolean flag = loginService.login(username, password);
            System.out.println("LoginController: doPost: flag=" + flag);
            if(flag) {
                System.out.println("LoginController: doPost: Login success!");
                session.setAttribute("username", username);

                request.setAttribute("username", username);
                request.setAttribute("msg", "Login Success.....");
                page = "home.jsp";
            } else {
                request.setAttribute("msg", "Wrong Username or Password, Try again!");
            }
        } else {
            request.setAttribute("msg", "Please enter username and password");
        }
        System.out.println("LoginController: doPost: sending request dispatcher");
        request.getRequestDispatcher(page).include(request, response);
    }
}
