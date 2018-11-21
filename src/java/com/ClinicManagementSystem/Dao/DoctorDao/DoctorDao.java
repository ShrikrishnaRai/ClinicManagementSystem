/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.DoctorDao;

import com.ClinicManagementSystem.Model.AppointmentDto.AppointmentDto;
import com.ClinicManagementSystem.Model.DoctorDto.DoctorDto;
import java.util.List;

/**
 *
 * @author cri_r
 */
public interface DoctorDao {

    public void saveDoctorInfo(DoctorDto doctorDto);

    public List selectDoctor();
    
    public boolean loginDoctor(String username, String password);
    
    public List<AppointmentDto> checkAppointment(String email);
    
    public DoctorDto getDoctorInfo(int id);
    
    public void deleteAppointment(int id);
}
