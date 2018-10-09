/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.DoctorDao;

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

}
