package com.cit360projectmark4.controller;

import com.cit360projectmark4.dao.BaseDao;
import com.cit360projectmark4.dao.BaseDaoImpl;
import com.cit360projectmark4.pojo.CapturedEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ShowController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("show_captured.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("ShowController: doPost: starting. SID: " + request.getSession().getId());
        String msg = "Captured Scabs";

        String page = "show_captured.jsp";
        String username = (String) session.getAttribute("username");
        BaseDao baseDao = new BaseDaoImpl();

        System.out.println("ShowController: doPost: creating list and saving to request");
        ArrayList<CapturedEntity> userScabs = new ArrayList<CapturedEntity>(baseDao.getCapturedScabs(username));
        request.setAttribute("scabList",userScabs);

        request.setAttribute("msg2", msg);
        System.out.println("ShowController: doPost: sending request dispatcher");
        request.getRequestDispatcher(page).include(request, response);
    }
}
