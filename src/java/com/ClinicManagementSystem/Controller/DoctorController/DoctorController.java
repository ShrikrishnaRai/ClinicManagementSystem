/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.DoctorController;

import com.ClinicManagementSystem.Model.DoctorDto.DoctorDto;
import com.ClinicManagementSystem.Service.AdminService.AdminService;
import com.ClinicManagementSystem.Service.AdminService.AdminServiceIMPL;
import com.ClinicManagementSystem.Service.DoctorService.DoctorService;
import com.ClinicManagementSystem.Service.DoctorService.DoctorServiceIMPL;
import static com.ClinicManagementSystem.Util.PageURL.DOCTOR_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.SIGNUP_DOCTOR_PAGE;
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
@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet {

    DoctorService doctorService_Ic = new DoctorServiceIMPL();
    AdminService adminService_Ic = new AdminServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setFirstName(req.getParameter("firstname"));
        doctorDto.setLastName(req.getParameter("lastname"));
        doctorDto.setEmail(req.getParameter("email"));
        doctorDto.setSpecialization(req.getParameter("specialization"));
        doctorDto.setPassword(req.getParameter("password"));
        doctorService_Ic.saveDoctorInfo(doctorDto);
        RequestDispatcher rd = req.getRequestDispatcher(SIGNUP_DOCTOR_PAGE);
        req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
        req.setAttribute("message", "Sucessfully Created Doctor's Account");
        rd.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(DOCTOR_PAGE);
        HttpSession session = req.getSession(true);
        req.setAttribute("message", "Welcome " + session.getAttribute("userName") + "\t to \t" + "Clinic Management System");
        int id = Integer.parseInt(req.getParameter("id"));
        doctorService_Ic.deleteAppointment(id);
        req.setAttribute("appointment", doctorService_Ic.checkAppointment(session.getAttribute("userName").toString()));

        rd.forward(req, resp);
    }

}
