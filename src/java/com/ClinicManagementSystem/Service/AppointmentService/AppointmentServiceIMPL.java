/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Service.AppointmentService;

import com.ClinicManagementSystem.Dao.AppointmentDao.ApointmentDaoIMPL;
import com.ClinicManagementSystem.Dao.AppointmentDao.AppointmentDao;
import com.ClinicManagementSystem.Dto.AppointmentDto.AppointmentDto;

/**
 *
 * @author cri_r
 */
public class AppointmentServiceIMPL implements AppointmentService {

    AppointmentDao appointmentDao_Ic;

    public AppointmentServiceIMPL() {
        appointmentDao_Ic = new ApointmentDaoIMPL();

    }

    @Override
    public boolean checkDoctor(String firstname, String lastname) {
        if (appointmentDao_Ic.checkDoctor(firstname, lastname)) {
            return true;
        }
        return false;
    }

    @Override
    public void saveAppointment(AppointmentDto appointmentDto) {
        appointmentDao_Ic.saveAppointment(appointmentDto);
    }

}
