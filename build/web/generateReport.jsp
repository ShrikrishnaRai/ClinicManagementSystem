<%-- 
    Document   : generateReport
    Created on : 14-Oct-2018, 19:53:28
    Author     : cri_r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report page</title>
    </head>
    <body>
        Available Patient's List
        <c:if test="${!empty patient}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${patient}" var="patient">
                        <tr>
                            <td>
                                <c:out value="${patient.id}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.firstName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.lastName}"></c:out>
                                </td>
                                <td>
                                <c:out value="${patient.email}"></c:out>
                                </td>
                            </tr>

                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <br><br>
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
        <br><br>


        <br><br>
        Enter Patient Report
        <form action="AdminController" method="post">
            Patient First Name:<input type="text" name="patientfirstname"/><br><br>
            Patient Last Name:<input type="text" name="patientlastname"/><br><br>
            Patient Email:<input type="email" name="email"/><br><br>
            Checked By<br><br>
            Doctor's First Name:<input type="text" name="doctorFirstName"/><br><br>
            Doctor's Last Name:<input type="text" name="doctorLastName"/><br><br>
            Patient Disease:<input type="text" name="disease"/><br><br>
            Blood Group:<input type="text" name="bloodgroup"/><br><br>
            Blood Pressure:<input type="text" name="bloodpressure"/><br><br>
            Sugar Level:<input type="text" name="sugarlevel"/><br><br>
            Remarks:<input type="text" name="remarks"/><br><br>
            <input type="submit" value="Enter"/>
        </form>
        <c:if test="${!empty message}">
            <c:out value="${message}"></c:out>
        </c:if>
    </body>
</html>
