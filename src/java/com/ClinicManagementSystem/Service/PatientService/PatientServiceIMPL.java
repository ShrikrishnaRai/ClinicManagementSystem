/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Service.PatientService;

import com.ClinicManagementSystem.Dao.PatientDao.PatientDao;
import com.ClinicManagementSystem.Dao.PatientDao.PatientDaoIMPL;
import com.ClinicManagementSystem.Dto.PatientDto.PatientDto;
import java.util.List;

/**
 *
 * @author cri_r
 */
public class PatientServiceIMPL implements PatientService {

    private PatientDao patientDao_Ic;

    public PatientServiceIMPL() {
        patientDao_Ic = new PatientDaoIMPL();
    }

    public void savePatientInfo(PatientDto patientDto_Ic) {
        patientDao_Ic.savePatientInfo(patientDto_Ic);
    }

    @Override
    public List<PatientDto> getPatientInfo() {
        return patientDao_Ic.getPatientInfo();
    }

}
