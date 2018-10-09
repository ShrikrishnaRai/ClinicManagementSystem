/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.DoctorAppointmentScheduleDao;

import com.ClinicManagementSystem.Model.DoctorAppointmentScheduleDto.DoctorAppointmentScheduleDto;
import java.util.Date;

/**
 *
 * @author cri_r
 */
public interface DoctorAppointmentScheduleDao {

    public void saveDoctorAppointmentSchedule(DoctorAppointmentScheduleDto doctorAppointmentSchedule);

    public boolean checkAvailability(String starttime, String endtime, Date date, String doctorfirstname, String doctorlastname);
}
