<%-- 
    Document   : patientSignup
    Created on : 24-Sep-2018, 13:11:34
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
        SignUp Patient
        <br><br>
        <form action="PatientController" method="post">
            First Name:<input type="text" name="firstname"><br><br>
            Last Name:<input type="text" name="lastname"><br><br>
            Email:<input type="email" name="email"><br><br>
            Password:<input type="password" name="password"><br><br>
            <input type="submit" value="submit"><br><br>
        </form>
    </body>
</html>
