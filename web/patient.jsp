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
        <title>JSP Page</title>
    </head>
    <body>
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
        <c:if test="${!empty message}">
            <c:out value="${message}"></c:out>
        </c:if>
        <form action="PatientController" method="post">
            <input type="submit" value="Check My Report" name="action"/>
        </form>
    </body>
</html>
