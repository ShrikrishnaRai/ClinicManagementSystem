/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Service.DoctorAppointmentScheduleService;

import com.ClinicManagementSystem.Dao.DoctorAppointmentScheduleDao.DoctorAppointmentScheduleDao;
import com.ClinicManagementSystem.Dao.DoctorAppointmentScheduleDao.DoctorAppointmentScheduleDaoIMPL;
import com.ClinicManagementSystem.Model.DoctorAppointmentScheduleDto.DoctorAppointmentScheduleDto;
import java.util.Date;

/**
 *
 * @author cri_r
 */
public class DoctorAppointmentScheduleServiceIMPL implements DoctorAppointmentScheduleService {

    DoctorAppointmentScheduleDao doctorAppointmentScheduleDao_Ic;

    public DoctorAppointmentScheduleServiceIMPL() {
        doctorAppointmentScheduleDao_Ic = new DoctorAppointmentScheduleDaoIMPL();

    }

    @Override
    public void saveDoctorAppointmentSchedule(DoctorAppointmentScheduleDto DoctorAppointmentSchedule) {
        doctorAppointmentScheduleDao_Ic.saveDoctorAppointmentSchedule(DoctorAppointmentSchedule);
    }



}
