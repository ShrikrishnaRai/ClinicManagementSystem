/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.PatientDao;

import com.ClinicManagementSystem.Util.DbUtil;
import com.ClinicManagementSystem.Util.QueryUtil;
import com.ClinicManagementSystem.Dto.PatientDto.PatientDto;
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

}