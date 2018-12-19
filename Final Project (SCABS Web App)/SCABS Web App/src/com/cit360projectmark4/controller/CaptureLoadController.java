package com.cit360projectmark4.controller;

import com.cit360projectmark4.dao.BaseDao;
import com.cit360projectmark4.dao.BaseDaoImpl;

import com.cit360projectmark4.pojo.TempScab;
import com.cit360projectmark4.util.ScabsCreationUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CaptureLoadController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("capture_load.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("CaptureLoadController: doPost: starting. SID: " + request.getSession().getId());
        String msg = "Input amount must be a number!";

        String page = "capture_load.jsp";
        String string_calories = request.getParameter("calories");

        try {
            System.out.println("CaptureLoadController: doPost: parsing input");
            int calories = Integer.parseInt(string_calories);

            System.out.println("CaptureLoadController: doPost: retrieving username");
            String username = (String) session.getAttribute("username");

            System.out.println("CaptureLoadController: doPost: sending data to Dao");
            BaseDao baseDao = new BaseDaoImpl();
            msg = baseDao.useCalories(username,calories);

            if (msg.equals("Calories accepted!")) {
                System.out.println("CaptureLoadController: doPost: Calorie input accepted");
                page = "capture_pick.jsp";
                ScabsCreationUtil createdScabs = new ScabsCreationUtil();

                System.out.println("CaptureLoadController: doPost: creating random Scabs");
                ArrayList<TempScab> scabs = createdScabs.getScabs(calories);

                for (int i = 0; i < scabs.size(); i++) {
                    System.out.println("CaptureLoadController: doPost: created " + scabs.get(i).toString());
                    request.setAttribute("scab" + i + "name", scabs.get(i).getName());
                    request.setAttribute("scab" + i + "str", scabs.get(i).getStr());
                    request.setAttribute("scab" + i + "luck", scabs.get(i).getLuck());
                }
            }

        } catch (Exception exception) {
            System.out.println("CaptureLoadController: doPost: Exception occurred. Message: " + exception.getMessage());
        }

        request.setAttribute("msg2", msg);
        System.out.println("CaptureLoadController: doPost: sending request dispatcher");
        request.getRequestDispatcher(page).include(request, response);
    }
}
