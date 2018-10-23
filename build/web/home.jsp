<%-- 
    Document   : home.jsp
    Created on : 30-Sep-2018, 12:42:32
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
        <form action="HomeController" method="post">
            <input type="submit" value="Appointment" name="action"/>
            <input type="submit" value="Doctor" name="action"/> 
            <input type="submit" value="report" name="action"/>
        </form>
        <form>
        </form>

    </body>
</html>
