/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.AppointmentDao;

import com.ClinicManagementSystem.Model.AppointmentDto.AppointmentDto;

/**
 *
 * @author cri_r
 */
public interface AppointmentDao {

    public boolean checkDoctor(String firstname, String lastname);

    public boolean checkPatient(String firstname, String lastname);

    public void saveAppointment(AppointmentDto appointmentDto);

}
