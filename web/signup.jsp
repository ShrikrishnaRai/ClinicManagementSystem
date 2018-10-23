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
        <link rel="shortcut icon" type="image/x-icon" href="https://www.shareicon.net/download/2016/07/12/795016_medical_512x512.png" />
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
            <input type="submit" value="submit" name="action" ><br><br>
        </form>
    </body>
</html>
