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

    public static final String CREATE_PATIENT = "insert into patient(email,password,firstname,lastname)values(?,?,?,?)";
    public static final String CREATE_DOCTOR = "insert into doctor_info(email,password,firstname,lastname,specialization)values(?,?,?,?,?)";
    public static final String SELECT_PATIENT = "select * from patient";
    public static final String SELECT_DOCTOR = "select * from doctor_info";
    public static final String LOGIN_ADMIN = "select * from admin where username=? and password=?";
    public static final String LOGIN_PATIENT = "select * from patient where email=? and password=?";
    public static final String LOGIN_DOCTOR = "select * from doctor_info where email=? and password=?";
    public static final String CHECK_DOCTOR = "select * from doctor_info where firstname=? and lastname=?";
    public static final String CHECK_PATIENT = "select * from patient where firstname=? and lastname=?";
    public static final String SAVE_APPOINTMENT = "insert into appointmentInfo(doctorname,doctorlastname,patientname,appointmentdate,appointmenttime,patientproblem,email,patientEmail) values(?,?,?,?,?,?,?,?)";
    public static final String CREATE_DOCTOR_APPOINTMENT_SCHEDULE = "insert into appointmentschedule(doctorfirstname,doctorlastname,starttime,endtime,date)values(?,?,?,?,?)";
    public static final String CHECK_APPOINTMENT_AVAILABILITY = "select * from apointmentschedule where starttime=? and endtime=? and date=? and doctorfirstname=? and doctorlastname=?";
    public static final String DELETE_DOCTOR = "delete from doctor_info where id=?";
    public static final String CREATE_REPORT = "insert into report(patientfirstname,patientlastname,doctorfirstname,doctorlastname,disease,bloodgroup,bloodpressure,sugarlevel,remarks,email) values (?,?,?,?,?,?,?,?,?,?)";
    public static final String CHECK_REPORT = "select * from report where email=?";
    public static final String USER_DETAIL = "select * from report where email=?";
    public static final String CHECK_DOCTOR_APPOINTMENT = "select * from appointmentInfo where email=?";
    public static final String UPDATE_DOCTOR = "update doctor_info set email=? firstname=? lastname=? specialization=? password=? where id=?";
    public static final String CHECK_DOCTOR_ID = "select * from doctor_info where id=?";
    public static final String DELETE_APPOINTMENT = "delete from appointmentinfo where id=? ";
    public static final String CHECK_APPOINTMENT_PATIENT = "select * from appointmentinfo where patientEmail=?";
    public static final String DELETE_APPOINTMENT_PATIENT= "delete from appointmentinfo where id=?";
}
