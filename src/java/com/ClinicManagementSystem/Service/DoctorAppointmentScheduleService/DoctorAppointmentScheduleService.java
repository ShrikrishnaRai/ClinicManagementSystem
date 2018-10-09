/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Service.DoctorAppointmentScheduleService;

import com.ClinicManagementSystem.Dto.DoctorAppointmentScheduleDto.DoctorAppointmentScheduleDto;
import java.util.Date;

/**
 *
 * @author cri_r
 */
public interface DoctorAppointmentScheduleService {

    public void saveDoctorAppointmentSchedule(DoctorAppointmentScheduleDto DoctorAppointmentSchedule);

    public boolean checkDoctorAvailability(String starttime, String endtime, Date date,String firstname,String lastname);
}
