package com.cit360projectmark4.controller;

import com.cit360projectmark4.dao.BaseDao;
import com.cit360projectmark4.dao.BaseDaoImpl;
import com.cit360projectmark4.pojo.CapturedEntity;
import com.cit360projectmark4.pojo.TempScab;
import com.cit360projectmark4.util.ScabsCreationUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CapturePickController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("capture_load.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("CapturePickController: doPost: starting. SID: " + request.getSession().getId());
        String page = "capture_conf.jsp";

        System.out.println("CapturePickController: doPost: Getting selected Scan data");
        String scab_name = request.getParameter("scabName");
        int scab_str = Integer.parseInt(request.getParameter("scabStr"));
        int scab_luck = Integer.parseInt(request.getParameter("scabLuck"));
        String username = (String) session.getAttribute("username");

        String msg = "There was an error saving your Scab! Contact Scab Admin";

        try {
            System.out.println("CapturePickController: doPost: creating captured scab");
            CapturedEntity new_scab = new CapturedEntity();
            new_scab.setOwner(username);
            new_scab.setScab(scab_name);
            new_scab.setCapturedStr(scab_str);
            new_scab.setCapturedLuck(scab_luck);

            System.out.println("CapturePickController: doPost: creating Dao");
            BaseDao baseDao = new BaseDaoImpl();
            System.out.println("CapturePickController: doPost: Saving captured scab: " + new_scab.getScab()+ ":ID:" + new_scab.getCapturedId());
            msg = baseDao.storeCapturedScab(new_scab);

            System.out.println("CaptureLoadController: doPost: adding scab to request");
            request.setAttribute("confScabName", new_scab.getScab());
            request.setAttribute("confScabStr", new_scab.getCapturedStr());
            request.setAttribute("confScabLuck", new_scab.getCapturedLuck());

        } catch (Exception exception) {
            System.out.println("CapturePickController: doPost: Exception occurred. Message: " + exception.getMessage());
        }

        request.setAttribute("msg2", msg);
        System.out.println("CapturePickController: doPost: sending request dispatcher");
        request.getRequestDispatcher(page).include(request, response);
    }
}
