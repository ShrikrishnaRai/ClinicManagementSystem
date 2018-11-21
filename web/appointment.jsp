<%-- 
    Document   : Appointment
    Created on : 26-Sep-2018, 15:05:25
    Author     : cri_r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="https://www.shareicon.net/download/2016/07/12/795016_medical_512x512.png" />
        <title>Appointment</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <div>
            <center>
                

                Available Doctor's List
                <c:if test="${!empty doctor}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Firstname</th>
                                <th>Lastname</th>
                                <th>Email</th>
                                <th>Specialization</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${doctor}" var="doctor">
                                <tr>
                                    <td>
                                        <c:out value="${doctor.id}"></c:out>
                                        </td>
                                        <td>
                                        <c:out value="${doctor.firstName}"></c:out>
                                        </td>
                                        <td>
                                        <c:out value="${doctor.lastName}"></c:out>
                                        </td>
                                        <td>
                                        <c:out value="${doctor.email}"></c:out>
                                        </td>
                                        <td>
                                        <c:out value="${doctor.specialization}"></c:out>
                                        </td>
                                    </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
        </div>
        <form action="AppointmentController" method="post" class="form-horizontal" style="margin:0.5%">
            <label>
                Appointment Form 
            </label><br><br>
            <label>Patient Name </label>
            <input type="text" name="patientname" class="form-control" style="width: 20%" placeholder="Patient Name"/><br><br>
            <label>Appointment Date</label> <input type="Date" name="date" class="form-control" style="width: 20%" placeholder="Date"/><br><br>
            <label>Appointment Time</label> <input type="Time" name="time" class="form-control" style="width:20%" placeholder="Time"/><br><br>
            <label>Mention Your Problem</label> <input type="text" name="problem" class="form-control" style="width:20% " placeholder="Headache..."/><br><br>
            <label>Doctor First Name</label> <input type="text" name="doctorfirstname" class="form-control" style="width:20%" placeholder="Doctor Firstname"/><br><br>
            <label>Doctor Last Name</label><input type="text" name="doctorlastname" class="form-control" style="width:20%" placeholder="Doctor Lastname"/><br><br>
            <label>Doctor Email</label><input type="text" name="email" class="form-control" style="width:20%" placeholder="Doctor Email"/><br><br>
            <label>Patient Email</label><input type="text" name="patientEmail" placeholder="Patient Email"/><br><br>
            <input type="submit" value="Submit" class="btn btn-primary"/>
        </form>
        <c:if test="${!empty message}">
            <c:out value="${message}"></c:out>
        </c:if>




    </body>
</html>
