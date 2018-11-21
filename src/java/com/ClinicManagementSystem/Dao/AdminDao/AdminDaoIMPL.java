/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.AdminDao;

import com.ClinicManagementSystem.Model.DoctorDto.DoctorDto;
import com.ClinicManagementSystem.Model.ReportDto.ReportDto;
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
public class AdminDaoIMPL implements AdminDao {

    PreparedStatement ps;

    @Override
    public boolean login(String username, String password) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.LOGIN_ADMIN);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs_Dco = ps.executeQuery();
            if (rs_Dco.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void deleteDoctor(int id) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.DELETE_DOCTOR);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void saveReport(ReportDto reportDto) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.CREATE_REPORT);
            ps.setString(1, reportDto.getPatientFirstName());
            ps.setString(2, reportDto.getPatientLastName());
            ps.setString(3, reportDto.getDoctorFirstName());
            ps.setString(4, reportDto.getDoctorLastName());
            ps.setString(5, reportDto.getDisease());
            ps.setString(6, reportDto.getBloodGroup());
            ps.setString(7, reportDto.getBloodPressure());
            ps.setString(8, reportDto.getSugarLevel());
            ps.setString(9, reportDto.getRemarks());
            ps.setString(10, reportDto.getEmail());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateDoctorInfo(DoctorDto doctorDto) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.UPDATE_DOCTOR);
            ps.setString(1, doctorDto.getEmail());
            ps.setString(2, doctorDto.getFirstName());
            ps.setString(3, doctorDto.getLastName());
            ps.setString(4, doctorDto.getSpecialization());
            ps.setString(5, doctorDto.getPassword());
            ps.setInt(6, doctorDto.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
