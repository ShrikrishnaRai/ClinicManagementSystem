/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Controller.AdminController;

import com.ClinicManagementSystem.Model.DoctorDto.DoctorDto;
import com.ClinicManagementSystem.Service.AdminService.AdminService;
import com.ClinicManagementSystem.Service.AdminService.AdminServiceIMPL;
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
@WebServlet("/MicController")
public class MicController extends HttpServlet {

    AdminService adminService_Ic = new AdminServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DoctorDto doctorDto = new DoctorDto();
        RequestDispatcher rdd = req.getRequestDispatcher(UPDATE_DOCTOR_PAGE);
        doctorDto.setFirstName(req.getParameter("firstname"));
        doctorDto.setLastName(req.getParameter("lastname"));
        doctorDto.setEmail(req.getParameter("email"));
        doctorDto.setSpecialization(req.getParameter("specialization"));
        doctorDto.setPassword(req.getParameter("password"));
        doctorDto.setId(Integer.parseInt(req.getParameter("id")));
        adminService_Ic.updateDoctor(doctorDto);
        req.setAttribute("message", "Doctor's Detail Updated");
        rdd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

}
