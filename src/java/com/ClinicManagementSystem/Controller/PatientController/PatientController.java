/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.PatientController;

import com.ClinicManagementSystem.Service.PatientService.PatientService;
import com.ClinicManagementSystem.Service.PatientService.PatientServiceIMPL;
import com.ClinicManagmentSystem.Dto.PatientDto.PatientDto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author cri_r
 */
@WebServlet("/PatientController")
public class PatientController extends HttpServlet {

    private static final String TEST_PAGE = "test.jsp";

    private static final long serialVersionUID = 1L;
    PatientService patientService_Ic = new PatientServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PatientDto patientDto_Ic = new PatientDto();
        patientDto_Ic.setFirstName(req.getParameter("firstname"));
        patientDto_Ic.setLastName(req.getParameter("lastname"));
        patientDto_Ic.setEmail(req.getParameter("email"));
        patientDto_Ic.setPassword(req.getParameter("password"));
        patientService_Ic.savePatientInfo(patientDto_Ic);
        RequestDispatcher rd = req.getRequestDispatcher(TEST_PAGE);
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
