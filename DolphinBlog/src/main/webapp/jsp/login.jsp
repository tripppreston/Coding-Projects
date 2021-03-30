<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dolphinStyles.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <style>
            body{
                background: url('https://static.pexels.com/photos/656/sea-water-ocean-dark.jpg');
                background-repeat: no-repeat;
                background-position: center center;
                background-attachment: fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                font-family: 'Oswald', sans-serif;
                
                
                
               login{ width: 50px;
    height: 50px;
    background-color: red;

    position: absolute;
    top:0;
    bottom: 0;
    left: 0;
    right: 0;

    margin: auto;
            }

            /* Styles specific to this page*/

        </style>
    </head>
    <body>
        
        <%@include file="loginnavbarfragment.jsp" %>
        
        <div class="container-fluid">
            <div class="col-sm-12"></div>
            <div class="col-sm-12"></div>
            <div class="col-sm-12"></div>
            <div class="col-sm-12"></div>
            <div class="col-sm-12"></div>
            <div class="col-sm-12"></div>
            <div class="col-sm-12"></div>
            <div class="col-sm-12"></div>
            <div class="col-sm-12"></div>
            <div class="login">
            <div class='col-sm-6 col-sm-offset-4 login'>

                <div class="col-sm-6">
                    <form action="j_spring_security_check" method="POST">
                        <br><br>
                        <div class="row form-group input-group input-group-lg">
                            <input type="text" class="form-control" 
                                   id="username" name="j_username" placeholder="Username">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        </div>

                        <div class="row form-group input-group input-group-lg">
                            <input type="password" class="form-control" 
                                   id="password" name="j_password" placeholder="Password">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        </div>
               
                <div>
                    <button id="loginBtn" type="submit" class="btn btn-lg btn-success">Log In</button>
                </div>
                </form>
            </div>
        </div>

    </div>  <!-- end container div -->



<script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ZdolphinJavaScript.js"></script>
</body>
</html>

