/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.LoginController;

import com.ClinicManagementSystem.Model.LoginDto.LoginDto;
import com.ClinicManagementSystem.Service.AdminService.AdminService;
import com.ClinicManagementSystem.Service.AdminService.AdminServiceIMPL;
import com.ClinicManagementSystem.Service.DoctorService.DoctorService;
import com.ClinicManagementSystem.Service.DoctorService.DoctorServiceIMPL;
import com.ClinicManagementSystem.Service.PatientService.PatientService;
import com.ClinicManagementSystem.Service.PatientService.PatientServiceIMPL;
import static com.ClinicManagementSystem.Util.PageURL.DOCTOR_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.HOME_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.INDEX_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.PATIENT_PAGE;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cri_r
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

    AdminService adminService_Ic = new AdminServiceIMPL();
    DoctorService doctorService_Ic = new DoctorServiceIMPL();
    PatientService patientSerivce_Ic = new PatientServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("userName", req.getParameter("username"));
        session.setAttribute("password", req.getParameter("password"));
        if ("Admin".equals(req.getParameter("role"))) {
            LoginDto adminDto = new LoginDto();
            adminDto.setUsername(req.getParameter("username"));
            adminDto.setPassword(req.getParameter("password"));
            if (adminService_Ic.login(adminDto.getUsername(), adminDto.getPassword())) {
                RequestDispatcher rd = req.getRequestDispatcher(HOME_PAGE);
                rd.forward(req, resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(INDEX_PAGE);
                req.setAttribute("message", "Username or Password UnMatched");
                rd.forward(req, resp);
            }
        }
        if ("Doctor".equals(req.getParameter("role"))) {
            if (doctorService_Ic.loginDoctor(req.getParameter("username"), req.getParameter("password"))) {
                RequestDispatcher rd = req.getRequestDispatcher(DOCTOR_PAGE);
                req.setAttribute("appointment", doctorService_Ic.checkAppointment(session.getAttribute("userName").toString()));
                req.setAttribute("message", "Welcome " + session.getAttribute("userName") + "\t to \t" + "Clinic Management System");
                rd.forward(req, resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(INDEX_PAGE);
                req.setAttribute("message", "Username of Password UnMatched");
                rd.forward(req, resp);
            }
        }
        if ("Patient".equals(req.getParameter("role"))) {
            LoginDto patientDto = new LoginDto();
            patientDto.setUsername(req.getParameter("username"));
            patientDto.setPassword(req.getParameter("password"));
            if (patientSerivce_Ic.loginPatient(patientDto.getUsername(), patientDto.getPassword())) {
                RequestDispatcher rd = req.getRequestDispatcher(PATIENT_PAGE);
                req.setAttribute("patient", patientSerivce_Ic.getPatientReport(session.getAttribute("userName").toString()));
                req.setAttribute("patient_a", patientSerivce_Ic.getAppointmentPatient(session.getAttribute("userName").toString()));
                req.setAttribute("message", "Welcome " + session.getAttribute("userName") + "\t to \t" + "Clinic Management System");
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
