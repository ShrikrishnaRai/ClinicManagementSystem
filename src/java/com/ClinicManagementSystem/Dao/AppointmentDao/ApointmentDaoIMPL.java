/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.AppointmentDao;

import com.ClinicManagementSystem.Model.AppointmentDto.AppointmentDto;
import com.ClinicManagementSystem.Util.DbUtil;
import com.ClinicManagementSystem.Util.QueryUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cri_r
 */
public class ApointmentDaoIMPL implements AppointmentDao {

    PreparedStatement ps;

    @Override
    public boolean checkDoctor(String firstname, String lastname) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.CHECK_DOCTOR);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ResultSet rs_Dco = ps.executeQuery();
            if (rs_Dco.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApointmentDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApointmentDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public void saveAppointment(AppointmentDto appointmentDto) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.SAVE_APPOINTMENT);
            ps.setString(1, appointmentDto.getDoctorName());
            ps.setString(2, appointmentDto.getDoctorLastName());
            ps.setString(3, appointmentDto.getPatientName());
            ps.setDate(4, new java.sql.Date(appointmentDto.getAppointmentDate().getTime()));
            ps.setString(5, appointmentDto.getAppointmentTime());
            ps.setString(6, appointmentDto.getPatientProblem());
            ps.setString(7, appointmentDto.getEmail());
            ps.setString(8, appointmentDto.getPatientEmail());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ApointmentDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApointmentDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean checkPatient(String firstname, String lastname) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.CHECK_PATIENT);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ResultSet rc_Dco = ps.executeQuery();
            if (rc_Dco.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApointmentDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApointmentDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
