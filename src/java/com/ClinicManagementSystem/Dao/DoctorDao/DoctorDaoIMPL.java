/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.DoctorDao;

import com.ClinicManagementSystem.Dto.DoctorDto.DoctorDto;
import com.ClinicManagementSystem.Util.DbUtil;
import com.ClinicManagementSystem.Util.QueryUtil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cri_r
 */
public class DoctorDaoIMPL implements DoctorDao {

    PreparedStatement ps;

    @Override
    public void saveDoctorInfo(DoctorDto doctorDto) {
        try {
            ps = DbUtil.getConnection().prepareStatement(QueryUtil.CREATE_DOCTOR);
            ps.setString(1, doctorDto.getEmail());
            ps.setString(2, doctorDto.getPassword());
            ps.setString(3, doctorDto.getFirstname());
            ps.setString(4, doctorDto.getLastname());
            ps.setString(5, doctorDto.getSpecialization());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorDaoIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
