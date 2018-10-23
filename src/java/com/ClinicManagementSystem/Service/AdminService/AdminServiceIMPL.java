/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Service.AdminService;

import com.ClinicManagementSystem.Dao.AdminDao.AdminDao;
import com.ClinicManagementSystem.Dao.AdminDao.AdminDaoIMPL;
import com.ClinicManagementSystem.Model.ReportDto.ReportDto;

/**
 *
 * @author cri_r
 */
public class AdminServiceIMPL implements AdminService {

    private AdminDao adminDao_Ic;

    public AdminServiceIMPL() {
        adminDao_Ic = new AdminDaoIMPL();
    }

    @Override
    public boolean login(String username, String password) {
        if (adminDao_Ic.login(username, password)) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteDoctor(int id) {
        adminDao_Ic.deleteDoctor(id);
    }

    @Override
    public void saveReport(ReportDto reportDto) {
        adminDao_Ic.saveReport(reportDto);
    }

}
