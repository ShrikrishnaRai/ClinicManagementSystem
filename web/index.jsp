<%-- 
    Document   : index
    Created on : 23-Sep-2018, 22:11:36
    Author     : cri_r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="https://www.shareicon.net/download/2016/07/12/795016_medical_512x512.png" />

        <title>Clinic Management System</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <div>
            <form action="LoginController" method="post">
                <div>
                Email: <input type="text" class="form-control"  name="username" style="width:15%; margin-left:  0.5%"/>
                </div>
                Password:<input type="text" class="form-control" name="password"/>
                <select name="role">
                    <option value="Admin">Admin</option>
                    <option value="Doctor">Doctor</option>
                    <option value="Patient">Patient</option>
                </select>
                <br><br>
                <input type="submit"  class="btn btn-primary" value="Login"/>
            </form>
        </div>
        else
        <br><br>
        <a href="signup.jsp">SignUp Here</a>
        <c:if test="${!empty message}">
            <c:out value="${message}"></c:out>
        </c:if>
        <c:if test="${!empty value}">
            <c:out value="${value}"></c:out>
        </c:if>
        <br><br>
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="http://urgentcare.ca/wp-content/uploads/2013/07/Untitled-1.png" alt="Los Angeles">
                </div>

                <div class="item">
                    <img src="http://vkool.com/wp-content/uploads/2015/04/how-to-cure-heart-disease-620x350.jpg" alt="Chicago">
                </div>

                <div class="item">
                    <img src="https://neurocure.de/assets/images/3/Zelle_Fotolia-50da57d3.jpg" alt="New York">
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" >
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </body>
</html>
