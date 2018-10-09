/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.AdminController;

import com.ClinicManagementSystem.Service.AdminService.AdminService;
import com.ClinicManagementSystem.Service.AdminService.AdminServiceIMPL;
import static com.ClinicManagementSystem.Util.PageURL.ADMIN_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.INDEX_PAGE;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cri_r
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {

    AdminService adminService_Ic = new AdminServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actions = req.getParameter("actions");
        if (actions.equals("delete")) {
            RequestDispatcher rd = req.getRequestDispatcher(ADMIN_PAGE);
            int id = Integer.parseInt(req.getParameter("id"));
            adminService_Ic.deleteDoctor(id);
            rd.forward(req, resp);
        }
        if (actions.equals("edit")) {
            RequestDispatcher rd = req.getRequestDispatcher(INDEX_PAGE);
            rd.forward(req, resp);
        }
    }

}
