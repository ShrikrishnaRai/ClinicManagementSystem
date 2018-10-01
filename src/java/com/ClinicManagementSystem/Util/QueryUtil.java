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
    public static final String SELECT_PATIENT = "select * from patient_info";
    public static final String SELECT_DOCTOR = "select * from doctor_info";
    public static final String LOGIN_ADMIN = "select * from admin where username=? and password=?";
    public static final String LOGIN_PATIENT = "select * from patient_info where email=? and password=?";
    public static final String CHECK_DOCTOR = "select firstname , lastname from doctor_info where firstname=? and lastname=?";
    public static final String SAVE_APPOINTMENT = "insert into appointmentInfo(doctorname,doctorlastname,patientname,appointmentdate,appointmenttime,patientproblem) values(?,?,?,?,?,?)";
}
