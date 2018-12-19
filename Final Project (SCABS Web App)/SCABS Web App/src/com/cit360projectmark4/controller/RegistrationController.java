package com.cit360projectmark4.controller;

import com.cit360projectmark4.dao.BaseDao;
import com.cit360projectmark4.dao.BaseDaoImpl;
import com.cit360projectmark4.pojo.UsersEntity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("userRegistration.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RegistrationController: doPost: starting. SID: " + request.getSession().getId());
        String msg = "Password and confirm passwords must be same";
        String page = "userRegistration.jsp";

        if(request.getParameter("password").equals(request.getParameter("confPassword"))){
            System.out.println("RegistrationController: doPost: passwords match");
            UsersEntity user = new UsersEntity();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));

            System.out.println("RegistrationController: doPost: creating user " + user.toString());
            BaseDao baseDao = new BaseDaoImpl();
            msg = baseDao.register(user);
            page = "login.jsp";
            System.out.println("RegistrationController: doPost: user created");
        }
        request.setAttribute("msg2", msg);
        System.out.println("RegistrationController: doPost: sending request dispatcher");
        request.getRequestDispatcher(page).include(request, response);
    }
}
