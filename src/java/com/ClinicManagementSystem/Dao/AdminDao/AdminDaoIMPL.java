/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.AdminDao;

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

}
