package com.cit360projectmark4.controller;

import com.cit360projectmark4.dao.BaseDao;
import com.cit360projectmark4.dao.BaseDaoImpl;
import com.cit360projectmark4.service.BaseService;
import com.cit360projectmark4.service.BaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CaloriesController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("calories.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("CaloriesController: doPost: starting. SID: " + request.getSession().getId());

        String page = "calories.jsp";
        String string_calories = request.getParameter("calories");

        System.out.println("caloriesController: doPost: creating baseDao");
        BaseDao baseDao = new BaseDaoImpl();
        System.out.println("CaloriesController: doPost: retrieving session username");
        String username = (String) session.getAttribute("username");
        System.out.println("CaloriesController: doPost: running recordCalories with username: " + username);
        String msg = baseDao.recordCalories(username, string_calories);

        request.setAttribute("msg2", msg);
        System.out.println("CaloriesController: doPost: sending request dispatcher");
        request.getRequestDispatcher(page).include(request, response);
    }
}
