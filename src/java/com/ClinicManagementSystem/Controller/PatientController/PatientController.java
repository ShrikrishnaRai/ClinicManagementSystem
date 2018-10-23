/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.PatientController;

import com.ClinicManagementSystem.Service.PatientService.PatientService;
import com.ClinicManagementSystem.Service.PatientService.PatientServiceIMPL;
import com.ClinicManagementSystem.Model.PatientDto.PatientDto;
import static com.ClinicManagementSystem.Util.PageURL.PATIENTINFO_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.PATIENT_PAGE;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet("/PatientController")
public class PatientController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    PatientService patientService_Ic = new PatientServiceIMPL();
    List<PatientDto> patientDtoList = new ArrayList<>();
    PatientDto patientDto = new PatientDto();
    String firstName;
    String lastName;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String v = req.getParameter("action");
        HttpSession session = req.getSession(true);
        if (v.equals("Check My Report")) {
            RequestDispatcher rd = req.getRequestDispatcher(PATIENT_PAGE);
            patientDtoList = patientService_Ic.getPatientDetail(session.getAttribute("userName").toString());
            for (int i = 0; i <= patientDtoList.size(); i++) {
                firstName = patientDtoList.get(i).getFirstName();
                lastName = patientDtoList.get(i).getLastName();
            }
            req.setAttribute("patient", patientService_Ic.getPatientReport(firstName, lastName));
            rd.forward(req, resp);
        }
        PatientDto patientDto_Ic = new PatientDto();
        patientDto_Ic.setFirstName(req.getParameter("firstname"));
        patientDto_Ic.setLastName(req.getParameter("lastname"));
        patientDto_Ic.setEmail(req.getParameter("email"));
        patientDto_Ic.setPassword(req.getParameter("password"));
        patientService_Ic.savePatientInfo(patientDto_Ic);
        RequestDispatcher rd = req.getRequestDispatcher(PATIENTINFO_PAGE);
        req.setAttribute("patient", patientService_Ic.getPatientInfo());
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
