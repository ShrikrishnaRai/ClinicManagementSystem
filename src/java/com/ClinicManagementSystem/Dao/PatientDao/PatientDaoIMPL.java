/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.PatientDao;

import com.ClinicManagementSystem.Util.DbUtil;
import com.ClinicManagementSystem.Util.QueryUtil;
import com.ClinicManagementSystem.Model.PatientDto.PatientDto;
import com.ClinicManagementSystem.Model.ReportDto.ReportDto;
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
public class PatientDaoIMPL implements PatientDao {

    PreparedStatement ps;

    @Override
    public void savePatientInfo(PatientDto patientDto_Ic) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.CREATE_PATIENT);
            ps.setString(1, patientDto_Ic.getEmail());
            ps.setString(2, patientDto_Ic.getPassword());
            ps.setString(3, patientDto_Ic.getFirstName());
            ps.setString(4, patientDto_Ic.getLastName());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<PatientDto> getPatientInfo() {
        List<PatientDto> patientDtoList = new ArrayList<>();
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.SELECT_PATIENT);
            ResultSet rs_Dco = ps.executeQuery();
            while (rs_Dco.next()) {
                PatientDto patientDto = new PatientDto();
                patientDto.setId(rs_Dco.getInt("id"));
                patientDto.setFirstName(rs_Dco.getString("firstname"));
                patientDto.setLastName(rs_Dco.getString("lastname"));
                patientDto.setEmail(rs_Dco.getString("email"));
                patientDtoList.add(patientDto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patientDtoList;
    }

    @Override
    public boolean loginPatient(String username, String password) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.LOGIN_PATIENT);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs_Dco = ps.executeQuery();
            if (rs_Dco.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<ReportDto> getPatientReport(String patientFirstName, String patientLastName) {
        List<ReportDto> reportDtoList = new ArrayList<>();
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.CHECK_REPORT);
            ps.setString(1, patientFirstName);
            ps.setString(2, patientLastName);
            ResultSet rs_Dco = ps.executeQuery();
            while (rs_Dco.next()) {
                ReportDto reportDto = new ReportDto();
                reportDto.setId(rs_Dco.getInt("id"));
                reportDto.setPatientFirstName(rs_Dco.getString("patientFirstName"));
                reportDto.setPatientLastName(rs_Dco.getString("patientLastName"));
                reportDto.setDoctorFirstName(rs_Dco.getString("doctorFirstName"));
                reportDto.setDoctorLastName(rs_Dco.getString("doctorLastName"));
                reportDto.setDisease(rs_Dco.getString("disease"));
                reportDto.setBloodGroup(rs_Dco.getString("bloodGroup"));
                reportDto.setBloodPressure(rs_Dco.getString("bloodPressure"));
                reportDto.setSugarLevel(rs_Dco.getString("sugarLevel"));
                reportDto.setRemarks(rs_Dco.getString("remarks"));
                reportDtoList.add(reportDto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reportDtoList;
    }

    @Override
    public List<PatientDto> getPatientDetail(String email) {
        List<PatientDto> patientDtoList = new ArrayList<>();
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.USER_DETAIL);
            ps.setString(1, email);
            ResultSet rs_Dco = ps.executeQuery();
            PatientDto patientDto = new PatientDto();
            while (rs_Dco.next()) {
                patientDto.setFirstName(rs_Dco.getString("firstname"));
                patientDto.setLastName(rs_Dco.getString("lastname"));
                patientDtoList.add(patientDto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patientDtoList;
    }

}
