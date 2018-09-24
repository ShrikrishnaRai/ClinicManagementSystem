/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.DoctorController;

import com.ClinicManagementSystem.Dto.DoctorDto.DoctorDto;
import com.ClinicManagementSystem.Service.DoctorService.DoctorService;
import com.ClinicManagementSystem.Service.DoctorService.DoctorServiceIMPL;
import java.io.IOException;
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
public class DoctorController extends HttpServlet{
    
    /* PatientDto patientDto_Ic = new PatientDto();
        patientDto_Ic.setFirstName(req.getParameter("firstname"));
        patientDto_Ic.setLastName(req.getParameter("lastname"));
        patientDto_Ic.setEmail(req.getParameter("email"));
        patientDto_Ic.setPassword(req.getParameter("password"));
        patientService_Ic.savePatientInfo(patientDto_Ic);
        RequestDispatcher rd = req.getRequestDispatcher(TEST_PAGE);
        rd.forward(req, resp);*/
    DoctorService doctorService_Ic=new DoctorServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorDto doctorDto=new DoctorDto();
        doctorDto.setFirstname(req.getParameter("firstname"));
        doctorDto.setLastname(req.getParameter("lastname"));
        doctorDto.setEmail(req.getParameter("email"));
        doctorDto.setSpecialization(req.getParameter("specialization"));
        doctorDto.setPassword(req.getParameter("password"));
        doctorService_Ic.saveDoctorInfo(doctorDto);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
}
