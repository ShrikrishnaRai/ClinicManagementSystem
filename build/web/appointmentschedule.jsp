<%-- 
    Document   : appointmentschedule
    Created on : 07-Oct-2018, 21:26:34
    Author     : cri_r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor's Appointment Schedule</title>
    </head>
    <body>
        Create Doctor's Appointment Schedule

        <form action="DoctorAppointmentSchedule" method="post">
            Doctor's First Name:<input type="text" name="doctorfirstname"/><br><br>
            Doctor's Last Name:<input type="text" name="doctorlastname"/><br><br>
            Start Time:<input type="time" name="starttime"/><br><br>
            End Time:<input type="time" name="endtime"/><br><br>
            Date:<input type="date" name="date"/><br><br>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
