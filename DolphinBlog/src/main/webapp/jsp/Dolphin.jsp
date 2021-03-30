<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dolphinStyles.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <title>JSP Page</title>
        <style>

            @import url('https://fonts.googleapis.com/css?family=Oswald');

            body{
                background: url('http://wallpapercave.com/wp/RB16JiE.jpg');
                background-repeat: no-repeat;
                background-position: center center;
                background-attachment: fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
                font-family: 'Oswald', sans-serif;
                font-weight:bold;
            }
/*http://i.imgur.com/YuCTY0n.jpg?fb*/
        </style>
    </head>
    <body>
        <%@include file="loginnavbarfragment.jsp" %>
        <br>
        <div class="container">
            <div class="row">
                
                <div style="max-width:80%; margin: auto;" class="text-center">
                    <h1 style="color:white;">${title}</h1> <br>
                    
                    
                    <p style="color:white;">
                      ${content}

                    </p>
                </div>

            </div>

        </div>  
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/ZdolphinJavaScript.js"></script>
        
        <script src="${pageContext.request.contextPath}/js/NavBarDolphin.js"></script>

    </body>
</html>