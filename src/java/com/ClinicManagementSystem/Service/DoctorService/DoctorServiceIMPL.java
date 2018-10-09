/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Service.DoctorService;

import com.ClinicManagementSystem.Dao.DoctorDao.DoctorDao;
import com.ClinicManagementSystem.Dao.DoctorDao.DoctorDaoIMPL;
import com.ClinicManagementSystem.Model.DoctorDto.DoctorDto;
import java.util.List;

/**
 *
 * @author cri_r
 */
public class DoctorServiceIMPL implements DoctorService{
    private DoctorDao doctorDao_Ic;
    
    public DoctorServiceIMPL(){
        doctorDao_Ic=new DoctorDaoIMPL();
    }

    public void saveDoctorInfo(DoctorDto doctorDto) {
        doctorDao_Ic.saveDoctorInfo(doctorDto);
    }

    @Override
    public List<DoctorDto> getDoctorInfo() {
        return doctorDao_Ic.selectDoctor();
    }
    
}
