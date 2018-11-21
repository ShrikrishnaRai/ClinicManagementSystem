/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.PatientController;

import com.ClinicManagementSystem.Service.DoctorService.DoctorService;
import com.ClinicManagementSystem.Service.DoctorService.DoctorServiceIMPL;
import com.ClinicManagementSystem.Service.PatientService.PatientService;
import com.ClinicManagementSystem.Service.PatientService.PatientServiceIMPL;
import static com.ClinicManagementSystem.Util.PageURL.APPOINTMENT_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.DOCTORINFO_PAGE;
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
@WebServlet("/p")
public class pController extends HttpServlet {

    DoctorService doctorService_Ic = new DoctorServiceIMPL();
    PatientService patientService_Ic = new PatientServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(APPOINTMENT_PAGE);
        HttpSession session = req.getSession(true);
        req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actions = req.getParameter("actions");
        HttpSession session = req.getSession(true);
        int id = Integer.parseInt(req.getParameter("id"));
        if (actions.equals("delete")) {
            patientService_Ic.deleteAppointment(id);
            RequestDispatcher rd = req.getRequestDispatcher(PATIENT_PAGE);
            req.setAttribute("patient", patientService_Ic.getPatientReport(session.getAttribute("userName").toString()));
            req.setAttribute("patient_a", patientService_Ic.getAppointmentPatient(session.getAttribute("userName").toString()));
            req.setAttribute("message", "Welcome " + session.getAttribute("userName") + "\t to \t" + "Clinic Management System");
            rd.forward(req, resp);
        }
    }

}
