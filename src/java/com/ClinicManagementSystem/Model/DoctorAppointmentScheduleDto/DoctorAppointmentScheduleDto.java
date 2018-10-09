/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicManagementSystem.Model.DoctorAppointmentScheduleDto;

import java.util.Date;

/**
 *
 * @author cri_r
 */
public class DoctorAppointmentScheduleDto {
    private int id;
    private String doctorfirstname;
    private String doctorlastname;
    private String starttime;
    private String endtime;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctorfirstname() {
        return doctorfirstname;
    }

    public void setDoctorfirstname(String doctorfirstname) {
        this.doctorfirstname = doctorfirstname;
    }

    public String getDoctorlastname() {
        return doctorlastname;
    }

    public void setDoctorlastname(String doctorlastname) {
        this.doctorlastname = doctorlastname;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
