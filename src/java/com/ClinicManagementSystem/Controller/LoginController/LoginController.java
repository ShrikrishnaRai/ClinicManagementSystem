/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.LoginController;

import com.ClinicManagementSystem.Dto.LoginDto.LoginDto;
import com.ClinicManagementSystem.Service.AdminService.AdminService;
import com.ClinicManagementSystem.Service.AdminService.AdminServiceIMPL;
import com.ClinicManagementSystem.Service.PatientService.PatientService;
import com.ClinicManagementSystem.Service.PatientService.PatientServiceIMPL;
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
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    AdminService adminService_Ic = new AdminServiceIMPL();
    PatientService patientSerivce_Ic = new PatientServiceIMPL();
    public static final String ADMIN_PAGE = "admin.jsp";
    public static final String INDEX_PAGE = "index.jsp";
    public static final String APPOINTMENT_PAGE = "appointment.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if ("Admin".equals(req.getParameter("role").toString())) {
            LoginDto adminDto = new LoginDto();
            adminDto.setUsername(req.getParameter("username"));
            adminDto.setPassword(req.getParameter("password"));
            if (adminService_Ic.login(adminDto.getUsername(), adminDto.getPassword())) {
                RequestDispatcher rd = req.getRequestDispatcher(ADMIN_PAGE);
                rd.forward(req, resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(INDEX_PAGE);
                req.setAttribute("message", "Username or Password UnMatched");
                rd.forward(req, resp);
            }
        }
        if ("Doctor".equals(req.getParameter("role").toString())) {

            RequestDispatcher rd = req.getRequestDispatcher(INDEX_PAGE);
            req.setAttribute("message", "To be performed by Admin");
            rd.forward(req, resp);
        }
        if ("Patient".equals(req.getParameter("role").toString())) {
            LoginDto patientDto = new LoginDto();
            patientDto.setUsername(req.getParameter("username"));
            patientDto.setPassword(req.getParameter("password"));
            if (patientSerivce_Ic.loginPatient(patientDto.getUsername(), patientDto.getPassword())) {
                RequestDispatcher rd = req.getRequestDispatcher(APPOINTMENT_PAGE);
                rd.forward(req, resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(INDEX_PAGE);
                req.setAttribute("message", "Username or Password UnMatched");
                rd.forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
