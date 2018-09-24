/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.PatientDao;

import com.ClinicManagementSystem.Util.DbUtil;
import com.ClinicManagementSystem.Util.QueryUtil;
import com.ClinicManagmentSystem.Dto.PatientDto.PatientDto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

}
