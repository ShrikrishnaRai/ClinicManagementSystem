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

        <title>JSP Page</title>
    </head>
    <body>
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
    </body>
</html>
