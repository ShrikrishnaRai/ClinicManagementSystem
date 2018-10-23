/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.AdminDao;

import com.ClinicManagementSystem.Model.ReportDto.ReportDto;

/**
 *
 * @author cri_r
 */
public interface AdminDao {

    public boolean login(String username, String password);

    public void deleteDoctor(int id);

    public void saveReport(ReportDto reportDto);
}
