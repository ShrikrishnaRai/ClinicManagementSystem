/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.DoctorAppointmentScheduleController;

import com.ClinicManagementSystem.Controller.AppointmentController.AppointmentController;
import com.ClinicManagementSystem.Dto.DoctorAppointmentScheduleDto.DoctorAppointmentScheduleDto;
import com.ClinicManagementSystem.Service.DoctorAppointmentScheduleService.DoctorAppointmentScheduleService;
import com.ClinicManagementSystem.Service.DoctorAppointmentScheduleService.DoctorAppointmentScheduleServiceIMPL;
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
@WebServlet("/DoctorAppointmentSchedule")
public class DoctorAppointmentScheduleController extends HttpServlet {

    DoctorAppointmentScheduleService doctorAppointmentScheduleService_Ic = new DoctorAppointmentScheduleServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorAppointmentScheduleDto doctorAppointmentScheduleDto = new DoctorAppointmentScheduleDto();
        doctorAppointmentScheduleDto.setDoctorfirstname(req.getParameter("doctorfirstname"));
        doctorAppointmentScheduleDto.setDoctorlastname(req.getParameter("doctorlastname"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            doctorAppointmentScheduleDto.setDate(sdf.parse(req.getParameter("date")));
        } catch (ParseException ex) {
            Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        doctorAppointmentScheduleDto.setStarttime(req.getParameter("starttime"));
        doctorAppointmentScheduleDto.setEndtime(req.getParameter("endtime"));
        doctorAppointmentScheduleService_Ic.saveDoctorAppointmentSchedule(doctorAppointmentScheduleDto);
        RequestDispatcher rd = req.getRequestDispatcher(APPOINTMENT_PAGE);
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
