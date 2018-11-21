<%-- 
    Document   : updatedoctor
    Created on : 16-Nov-2018, 16:48:01
    Author     : cri_r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Doctor</title>
    </head>
    <body>
        <c:if test= "${!empty doctor}">
            <form action="MicController" method="post">
                id:<input readonly="readonly" name="id" value="${doctor.id}" /><br><br>
                Firstname:<input type="text" name="firstname" value="${doctor.firstName}"/><br><br>
                Lastname:<input type="text" name="lastname" value="${doctor.lastName}"/><br><br>
                Email:<input type="email" name="email" value="${doctor.email}"/><br><br>
                Specialization:<input type="text" name="specialization" ${doctor.specialization}/><br><br>
                Password:<input type="password" name="password"/><br><br>
                <input type="submit" value="update">
            </form>
        </c:if>

    </body>
</html>
