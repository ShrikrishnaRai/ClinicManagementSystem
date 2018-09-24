<%-- 
    Document   : index
    Created on : 23-Sep-2018, 22:11:36
    Author     : cri_r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginController" method="post">
            Email:<input type="text" name="email"/>
            Password:<input type="text" name="password"/>
            <select>
                <option value="Admin">Admin</option>
                <option value="Doctor">Doctor</option>
                <option value="Patient">Patient</option>
            </select>
            <br><br>
            <input type="submit" value="Login"/>
        </form>
        else
        <br><br>
        <a href="Signup.jsp">SignUp Here</a>

    </body>
</html>
