/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.DoctorAppointmentScheduleDao;

import com.ClinicManagementSystem.Model.DoctorAppointmentScheduleDto.DoctorAppointmentScheduleDto;
import com.ClinicManagementSystem.Util.DbUtil;
import com.ClinicManagementSystem.Util.QueryUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cri_r
 */
public class DoctorAppointmentScheduleDaoIMPL implements DoctorAppointmentScheduleDao {

    PreparedStatement ps;

    @Override
    public void saveDoctorAppointmentSchedule(DoctorAppointmentScheduleDto doctorAppointmentSchedule) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.CREATE_DOCTOR_APPOINTMENT_SCHEDULE);
            ps.setString(1, doctorAppointmentSchedule.getDoctorfirstname());
            ps.setString(2, doctorAppointmentSchedule.getDoctorlastname());
            ps.setString(3, doctorAppointmentSchedule.getStarttime());
            ps.setString(4, doctorAppointmentSchedule.getEndtime());
            ps.setDate(5, new java.sql.Date(doctorAppointmentSchedule.getDate().getDate()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorAppointmentScheduleDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorAppointmentScheduleDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean checkAvailability(String starttime, String endtime, Date date, String doctorfirstname, String doctorlastname) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.CHECK_APPOINTMENT_AVAILABILITY);
            ps.setString(1, starttime);
            ps.setString(2, endtime);
            ps.setDate(3, new java.sql.Date(date.getDate()));
            ps.setString(4, doctorfirstname);
            ps.setString(5, doctorlastname);
            ResultSet rs_Dco = ps.executeQuery();
            if (rs_Dco.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorAppointmentScheduleDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorAppointmentScheduleDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
