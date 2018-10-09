/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.DoctorController;

import com.ClinicManagementSystem.Model.DoctorDto.DoctorDto;
import com.ClinicManagementSystem.Service.DoctorService.DoctorService;
import com.ClinicManagementSystem.Service.DoctorService.DoctorServiceIMPL;
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
@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet {

    public static final String DOCTOR_PAGE = "doctorInfo.jsp";
    DoctorService doctorService_Ic = new DoctorServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setFirstName(req.getParameter("firstname"));
        doctorDto.setLastName(req.getParameter("lastname"));
        doctorDto.setEmail(req.getParameter("email"));
        doctorDto.setSpecialization(req.getParameter("specialization"));
        doctorDto.setPassword(req.getParameter("password"));
        doctorService_Ic.saveDoctorInfo(doctorDto);
        RequestDispatcher rd = req.getRequestDispatcher(DOCTOR_PAGE);
        req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}
