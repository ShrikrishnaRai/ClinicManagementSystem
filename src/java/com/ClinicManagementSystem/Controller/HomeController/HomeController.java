/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.HomeController;

import com.ClinicManagementSystem.Service.DoctorService.DoctorService;
import com.ClinicManagementSystem.Service.DoctorService.DoctorServiceIMPL;
import com.ClinicManagementSystem.Service.PatientService.PatientService;
import com.ClinicManagementSystem.Service.PatientService.PatientServiceIMPL;
import static com.ClinicManagementSystem.Util.PageURL.APPOINTMENT_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.DOCTORINFO_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.GENERATEREPORT_PAGE;
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
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {

    DoctorService doctorService_Ic = new DoctorServiceIMPL();
    PatientService patientService_Ic = new PatientServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String v = req.getParameter("action");
        if (v.equals("Doctor")) {
            RequestDispatcher rd = req.getRequestDispatcher(DOCTORINFO_PAGE);
            req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
            rd.forward(req, resp);
        }
        if (v.equals("Appointment")) {
            RequestDispatcher rd = req.getRequestDispatcher(APPOINTMENT_PAGE);
            req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
            rd.forward(req, resp);
        }
        if (v.equals("report")) {
            RequestDispatcher rd = req.getRequestDispatcher(GENERATEREPORT_PAGE);
            req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
            req.setAttribute("patient", patientService_Ic.getPatientInfo());
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); 
    }

}
