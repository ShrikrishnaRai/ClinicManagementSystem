<%-- 
    Document   : patient
    Created on : 18-Oct-2018, 07:23:14
    Author     : cri_r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Info</title>
    </head>
    <body>
        <c:if test="${!empty message}">
            <c:out value="${message}"></c:out>
        </c:if>
        <br><br>
        Your's Appointment
        <c:if test="${! empty patient_a}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Doctor Firstname</th>
                        <th>Doctor Lastname</th>
                        <th>Patient Name</th>
                        <th>Appointment Date</th>
                        <th>Appointment Time</th>
                        <th>Patient Problem</th>
                        <th>Maintain</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${patient_a}" var="patient_a">
                        <tr>
                            <td>

                                <c:out value="${patient_a.id}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient_a.doctorName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient_a.doctorLastName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient_a.patientName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient_a.appointmentDate}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient_a.appointmentTime}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient_a.patientProblem}"></c:out>
                                </td>
                                <td>
                                    <a href="p?actions=delete&id=<c:out value="${patient_a.id}"/>">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <br><br>

        <label>Your Report </label>

        <c:if test="${!empty patient}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Patient Firstname</th>
                        <th>Patient Lastname</th>
                        <th>Doctor Firstname</th>
                        <th>Doctor Lastname</th>
                        <th>Disease</th>
                        <th>Blood Group</th>
                        <th>Blood Pressure</th>
                        <th>Sugar Level</th>
                        <th>Remarks</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${patient}" var="patient">
                        <tr>
                            <td>

                                <c:out value="${patient.id}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.patientFirstName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.patientLastName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.doctorFirstName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.doctorLastName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.disease}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.bloodGroup}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.bloodPressure}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.sugarLevel}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.remarks}"></c:out>
                                </td>
                            </tr>

                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <br><br>

        <form action="p" method="POST">
            <input type="submit" value="Create Appointment"/>
        </form>
        <a href="index.jsp">Log Out</a>
    </body>
</html>
