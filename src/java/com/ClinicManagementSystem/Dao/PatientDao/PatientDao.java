/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.PatientDao;

import com.ClinicManagmentSystem.Dto.PatientDto.PatientDto;

/**
 *
 * @author cri_r
 */
public interface PatientDao {
    public void savePatientInfo(PatientDto patientDto_Ic);
}
