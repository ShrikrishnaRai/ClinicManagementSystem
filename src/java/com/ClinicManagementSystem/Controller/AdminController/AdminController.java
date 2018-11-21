/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.AdminController;

import com.ClinicManagementSystem.Model.DoctorDto.DoctorDto;
import com.ClinicManagementSystem.Model.ReportDto.ReportDto;
import com.ClinicManagementSystem.Service.AdminService.AdminService;
import com.ClinicManagementSystem.Service.AdminService.AdminServiceIMPL;
import com.ClinicManagementSystem.Service.AppointmentService.AppointmentService;
import com.ClinicManagementSystem.Service.AppointmentService.AppointmentServiceIMPL;
import com.ClinicManagementSystem.Service.DoctorService.DoctorService;
import com.ClinicManagementSystem.Service.DoctorService.DoctorServiceIMPL;
import com.ClinicManagementSystem.Service.PatientService.PatientService;
import com.ClinicManagementSystem.Service.PatientService.PatientServiceIMPL;
import static com.ClinicManagementSystem.Util.PageURL.DOCTORINFO_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.GENERATEREPORT_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.SIGNUP_PAGE;
import static com.ClinicManagementSystem.Util.PageURL.UPDATE_DOCTOR_PAGE;
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

    AdminService adminService_Ic    = new AdminServiceIMPL();
    DoctorService doctorService_Ic = new DoctorServiceIMPL();
    PatientService patientSerivce_Ic = new PatientServiceIMPL();
    AppointmentService appointmentService_Ic = new AppointmentServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReportDto reportDto = new ReportDto();
        if (appointmentService_Ic.checkDoctor(req.getParameter("doctorFirstName"), req.getParameter("doctorLastName"))) {
            if (appointmentService_Ic.checkPatient(req.getParameter("patientfirstname"), req.getParameter("patientlastname"))) {
                reportDto.setPatientFirstName(req.getParameter("patientfirstname"));
                reportDto.setPatientLastName(req.getParameter("patientlastname"));
                reportDto.setDoctorFirstName(req.getParameter("doctorFirstName"));
                reportDto.setDoctorLastName(req.getParameter("doctorLastName"));
                reportDto.setBloodGroup(req.getParameter("bloodgroup"));
                reportDto.setBloodPressure(req.getParameter("bloodpressure"));
                reportDto.setSugarLevel(req.getParameter("sugarlevel"));
                reportDto.setRemarks(req.getParameter("remarks"));
                reportDto.setDisease(req.getParameter("disease"));
                reportDto.setEmail(req.getParameter("email"));
                adminService_Ic.saveReport(reportDto);
                RequestDispatcher rd = req.getRequestDispatcher(GENERATEREPORT_PAGE);
                req.setAttribute("message", "Report Saved");
                req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
                req.setAttribute("patient", patientSerivce_Ic.getPatientInfo());
                rd.forward(req, resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(GENERATEREPORT_PAGE);
                req.setAttribute("message", "Select Patient's from list available");
                req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
                req.setAttribute("patient", patientSerivce_Ic.getPatientInfo());
                rd.forward(req, resp);
            }
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(GENERATEREPORT_PAGE);
            req.setAttribute("message", "Select Doctor's from list available");
            req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
            req.setAttribute("patient", patientSerivce_Ic.getPatientInfo());
            rd.forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actions = req.getParameter("actions");
        int id = Integer.parseInt(req.getParameter("id"));
        if (actions.equals("delete")) {
            RequestDispatcher rd = req.getRequestDispatcher(DOCTORINFO_PAGE);
            req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
            req.setAttribute("patient", patientSerivce_Ic.getPatientInfo());
            adminService_Ic.deleteDoctor(id);
            rd.forward(req, resp);
        }
        if (actions.equals("edit")) {
            RequestDispatcher rd = req.getRequestDispatcher(UPDATE_DOCTOR_PAGE);
            req.setAttribute("doctor", doctorService_Ic.getDoctorInfo(id));
            rd.forward(req, resp);
        }
    }

}
