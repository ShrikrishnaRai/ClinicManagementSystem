<%-- 
    Document   : test
    Created on : 24-Sep-2018, 13:45:47
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
    </body>
</html>
