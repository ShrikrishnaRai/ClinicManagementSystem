/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Service.PatientService;

import com.ClinicManagementSystem.Dao.PatientDao.PatientDao;
import com.ClinicManagementSystem.Dao.PatientDao.PatientDaoIMPL;
import com.ClinicManagementSystem.Model.AppointmentDto.AppointmentDto;
import com.ClinicManagementSystem.Model.PatientDto.PatientDto;
import com.ClinicManagementSystem.Model.ReportDto.ReportDto;
import java.util.List;

/**
 *
 * @author cri_r
 */
public class PatientServiceIMPL implements PatientService {

    private final PatientDao patientDao_Ic;

    public PatientServiceIMPL() {
        patientDao_Ic = new PatientDaoIMPL();
    }

    @Override
    public void savePatientInfo(PatientDto patientDto_Ic) {
        patientDao_Ic.savePatientInfo(patientDto_Ic);
    }

    @Override
    public List<PatientDto> getPatientInfo() {
        return patientDao_Ic.getPatientInfo();
    }

    @Override
    public boolean loginPatient(String username, String password) {
        return patientDao_Ic.loginPatient(username, password);
    }

    @Override
    public List<ReportDto> getPatientReport(String email) {
        return patientDao_Ic.getPatientReport(email);
    }

    @Override
    public List<PatientDto> getPatientDetail(String email) {
        return patientDao_Ic.getPatientDetail(email);
    }

    @Override
    public List<AppointmentDto> getAppointmentPatient(String email) {
        return patientDao_Ic.checkAppointment(email);
    }

    @Override
    public void deleteAppointment(int id) {
        patientDao_Ic.deleteAppointment(id);
    }

}
