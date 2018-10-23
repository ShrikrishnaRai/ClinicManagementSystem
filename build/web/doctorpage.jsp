<%-- 
    Document   : doctorpage
    Created on : 23-Oct-2018, 10:17:10
    Author     : cri_r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Appointment</title>
    </head>
    <body>
        <c:if test="${!empty appointment}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Patient Name</th>
                        <th>Doctor First Name</th>
                        <th>Doctor's Last Name</th>
                        <th>Patient Problem</th>
                        <th>Appointment Date</th>
                        <th>Appointment Time</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${doctor}" var="doctor">
                        <tr>
                            <td>
                                <c:out value="${appointment.id}"></c:out>
                                </td>
                                <td>
                                <c:out value="${appointment.patientName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${appointment.doctorName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${appointment.doctorLastName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${appointment.patientProblem}"></c:out>
                                </td>
                                <td>
                                <c:out value="${appointment.appointmentDate}"></c:out>
                                </td>
                                <td>
                                <c:out value="${appointment.appointmentTime}"></c:out>
                                </td>
                            </tr>

                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
