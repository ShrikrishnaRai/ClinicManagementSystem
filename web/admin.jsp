<%-- 
    Document   : admin
    Created on : 24-Sep-2018, 17:59:32
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
        Save Doctor Info
        <form action="DoctorController" method="post">
            Firstname:<input type="text" name="firstname"><br><br>
            Lastname:<input type="text" name="lastname"><br><br>
            Email:<input type="email" name="email"><br><br>
            Specialization:<input type="text" name="specialization"><br><br>
            Password:<input type="password" name="password"><br><br>
            <input type="submit" value="submit">
        </form>
    </body>
</html>
