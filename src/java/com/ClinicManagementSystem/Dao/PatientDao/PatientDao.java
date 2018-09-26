/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Dao.PatientDao;

import com.ClinicManagementSystem.Dto.PatientDto.PatientDto;
import java.util.List;

/**
 *
 * @author cri_r
 */
public interface PatientDao {

    public void savePatientInfo(PatientDto patientDto_Ic);

    public List<PatientDto> getPatientInfo();

    public boolean loginPatient(String username, String password);
}
