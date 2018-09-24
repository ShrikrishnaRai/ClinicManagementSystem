/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Util;

/**
 *
 * @author cri_r
 */
public class QueryUtil {

    public static final String CREATE_PATIENT = "insert into patient_info(email,password,firstname,lastname)values(?,?,?,?)";
    public static final String CREATE_DOCTOR = "insert into doctor_info(email,password,firstname,lastname,specialization)values(?,?,?,?,?)";
}
