/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.DoctorDao;

import com.ClinicManagementSystem.Model.AppointmentDto.AppointmentDto;
import com.ClinicManagementSystem.Model.DoctorDto.DoctorDto;
import com.ClinicManagementSystem.Util.DbUtil;
import com.ClinicManagementSystem.Util.QueryUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cri_r
 */
public class DoctorDaoIMPL implements DoctorDao {

    PreparedStatement ps;
    List<DoctorDto> doctorDtoList;

    @Override
    public void saveDoctorInfo(DoctorDto doctorDto) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.CREATE_DOCTOR);
            ps.setString(1, doctorDto.getEmail());
            ps.setString(2, doctorDto.getPassword());
            ps.setString(3, doctorDto.getFirstName());
            ps.setString(4, doctorDto.getLastName());
            ps.setString(5, doctorDto.getSpecialization());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List selectDoctor() {
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.SELECT_DOCTOR);
            ResultSet rs_Dco = ps.executeQuery();
            while (rs_Dco.next()) {
                DoctorDto doctorDto = new DoctorDto();
                doctorDto.setId(rs_Dco.getInt("id"));
                doctorDto.setEmail(rs_Dco.getString("email"));
                doctorDto.setFirstName(rs_Dco.getString("firstName"));
                doctorDto.setLastName(rs_Dco.getString("lastName"));
                doctorDto.setSpecialization(rs_Dco.getString("specialization"));
                doctorDtoList.add(doctorDto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctorDtoList;

    }

    @Override
    public boolean loginDoctor(String username, String password) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.LOGIN_DOCTOR);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs_Dco = ps.executeQuery();
            if (rs_Dco.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<AppointmentDto> checkAppointment(String email) {
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.CHECK_DOCTOR_APPOINTMENT);
            ps.setString(1, email);
            ResultSet rs_Dco = ps.executeQuery();
            while (rs_Dco.next()) {
                AppointmentDto appointmentDto = new AppointmentDto();
                appointmentDto.setId(Integer.parseInt(rs_Dco.getString("id")));
                appointmentDto.setPatientName(rs_Dco.getString("patientName"));
                appointmentDto.setDoctorName(rs_Dco.getString("doctorName"));
                appointmentDto.setDoctorLastName(rs_Dco.getString("doctorLastName"));
                appointmentDto.setPatientProblem(rs_Dco.getString("patientProblem"));
                appointmentDto.setAppointmentDate(rs_Dco.getDate("appointmentDate"));
                appointmentDto.setAppointmentTime(rs_Dco.getString("appointmentTime"));
                appointmentDtoList.add(appointmentDto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);

        }
        return appointmentDtoList;
    }

    @Override
    public DoctorDto getDoctorInfo(int id) {
        DoctorDto doctorDto = new DoctorDto();
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.CHECK_DOCTOR_ID);
            ps.setInt(1, id);
            ResultSet rs_Dco = ps.executeQuery();
            while (rs_Dco.next()) {
                doctorDto.setId(rs_Dco.getInt("id"));
                doctorDto.setEmail(rs_Dco.getString("email"));
                doctorDto.setFirstName(rs_Dco.getString("firstName"));
                doctorDto.setLastName(rs_Dco.getString("lastName"));
                doctorDto.setSpecialization(rs_Dco.getString("specialization"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctorDto;

    }

    @Override
    public void deleteAppointment(int id) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.DELETE_APPOINTMENT);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
