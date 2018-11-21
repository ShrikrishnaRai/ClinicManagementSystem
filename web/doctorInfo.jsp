<%-- 
    Document   : doctorInfo
    Created on : 25-Sep-2018, 16:47:12
    Author     : cri_r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="https://www.shareicon.net/download/2016/07/12/795016_medical_512x512.png" />

        <title>Doctor's Info</title>
    </head>
    <body>

        <label>Doctor's Available List</label></center>
        <c:if test="${!empty doctor}">
        <table border="1" class="table" style="margin:0.5%">
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
    <c:if test="${!empty message}">
        <c:out value="${message}"></c:out>
    </c:if>
    <br><br>
    <a href="signupdoctor.jsp">Create Doctor's Account</a>

</body>
</html>
