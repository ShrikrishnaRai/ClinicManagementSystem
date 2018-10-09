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
            <c:if test="${!empty doctor}">
                <table border="1" class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Doctor's name</th>
                            <th>Lastname</th>
                            <th>Email</th>
                            <th>Specialization</th>
                            <th>Maintain</th>
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
                                    <td>
                                        <a href="AdminController?actions=delete&id=<c:out value="${doctor.id}"/>">Delete</a>
                                    <a href="AdminController?actions=edit&id=<c:out value="${doctor.id}"/>">Edit</a>
                                </td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <form action="AppointmentController" method="post">
            Patient Detail form <br><br>
            Patient Name <input type="text" name="patientname"/><br><br>
            Appointment Date <input type="Date" name="date"/><br><br>
            Appointment Time <input type="Time" name="time"/><br><br>
            Mention Your Problem <input type="text" name="problem"/><br><br>
            Doctor First Name <input type="text" name="doctorfirstname"/><br><br>
            Doctor Last Name<input type="text" name="doctorlastname"/><br><br>
            <input type="submit" value="Submit"/>
        </form>
        <c:if test="${!empty message}">
            <c:out value="${message}"></c:out>
        </c:if>




    </body>
</html>
