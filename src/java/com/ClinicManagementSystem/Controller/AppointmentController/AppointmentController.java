/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.AppointmentController;

import com.ClinicManagementSystem.Dto.AppointmentDto.AppointmentDto;
import com.ClinicManagementSystem.Service.AppointmentService.AppointmentService;
import com.ClinicManagementSystem.Service.AppointmentService.AppointmentServiceIMPL;
import com.ClinicManagementSystem.Service.DoctorService.DoctorService;
import com.ClinicManagementSystem.Service.DoctorService.DoctorServiceIMPL;
import static com.ClinicManagementSystem.Util.PageURL.APPOINTMENT_PAGE;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet("/AppointmentController")
public class AppointmentController extends HttpServlet {

    AppointmentService appointmentService_Ic = new AppointmentServiceIMPL();
    DoctorService doctorService_Ic = new DoctorServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setDoctorName(req.getParameter("doctorfirstname"));
        appointmentDto.setDoctorLastName(req.getParameter("doctorlastname"));
        appointmentDto.setPatientName(req.getParameter("patientname"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            appointmentDto.setAppointmentDate(sdf.parse(req.getParameter("date")));
        } catch (ParseException ex) {
            Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        appointmentDto.setAppointmentTime(req.getParameter("time"));
        appointmentDto.setPatientProblem(req.getParameter("problem"));
        if (appointmentService_Ic.checkDoctor(appointmentDto.getDoctorName(), appointmentDto.getDoctorLastName())) {
            appointmentService_Ic.saveAppointment(appointmentDto);
            RequestDispatcher rd = req.getRequestDispatcher(APPOINTMENT_PAGE);
            req.setAttribute("message", "Your Appointment Saved");
            req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
            rd.forward(req, resp);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(APPOINTMENT_PAGE);
            req.setAttribute("message", "Please put Doctor name from Available list");
            req.setAttribute("doctor", doctorService_Ic.getDoctorInfo());
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
